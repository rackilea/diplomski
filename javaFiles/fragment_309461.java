import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.turbo.TurboFilter;
import ch.qos.logback.core.spi.FilterReply;
import org.slf4j.Marker;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class DuplicationTimeoutTurboFilter extends TurboFilter {

    private static final int CLEAN_UP_THRESHOLD = 1000;
    private ConcurrentHashMap<KeyPattern, LocalDateTime> recentlyMatchedPatterns = new ConcurrentHashMap<>();

    private Set<KeyPattern> ignoringPatterns = new HashSet<>();

    private long minutesToBlock = 3L;

    @Override
    public FilterReply decide(Marker marker, Logger logger, Level level, String format, Object[] params, Throwable t) {
        String rawLogMessage = format + Arrays.toString(params) + Objects.toString(t);  //sometimes throwable can be inserted into params argument

        Set<KeyPattern> matchedIgnoringSet = ignoringPatterns.stream()
                .filter(key -> match(key, logger, rawLogMessage))
                .collect(Collectors.toSet());

        if (!matchedIgnoringSet.isEmpty() && isLoggedRecently(matchedIgnoringSet)) {
            return FilterReply.DENY;
        }

        return FilterReply.NEUTRAL;
    }

    private boolean match(KeyPattern keyPattern, Logger logger, String rawText) {
        String loggerClass = keyPattern.getLoggerClass();
        String messagePattern = keyPattern.getMessage();
        return loggerClass.equals(logger.getName()) && rawText.contains(messagePattern);
    }

    private boolean isLoggedRecently(Set<KeyPattern> matchedIgnoredList) {
        for (KeyPattern pattern : matchedIgnoredList) {
            LocalDateTime now = LocalDateTime.now();

            LocalDateTime lastLogTime = recentlyMatchedPatterns.putIfAbsent(pattern, now);
            if (lastLogTime == null) {
                return false;
            }

            LocalDateTime blockedTillTime = lastLogTime.plusMinutes(minutesToBlock);
            if (blockedTillTime.isAfter(now)) {
                return true;
            } else if (blockedTillTime.isBefore(now)) {
                recentlyMatchedPatterns.put(pattern, now);
                cleanupIfNeeded();
                return false;
            }
        }
        return true;
    }

    private void cleanupIfNeeded() {
        if (recentlyMatchedPatterns.size() > CLEAN_UP_THRESHOLD) {
            LocalDateTime oldTime = LocalDateTime.now().minusMinutes(minutesToBlock * 2);
            recentlyMatchedPatterns.values().removeIf(lastLogTime -> lastLogTime.isAfter(oldTime));
        }
    }

    public long getMinutesToBlock() {
        return minutesToBlock;
    }

    public void setMinutesToBlock(long minutesToBlock) {
        this.minutesToBlock = minutesToBlock;
    }

    public void addKeyPattern(KeyPattern keyPattern) {
        ignoringPatterns.add(keyPattern);
    }

    public static class KeyPattern {
        private String loggerClass;
        private String message;

        //constructor, getters, setters, equals, hashcode
    }
}