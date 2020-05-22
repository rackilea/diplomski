import java.util.Collection;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ReplaceMap {
    private final Pattern p;

    public ReplaceMap(Collection<String> keys) {
        this.p = Pattern.compile(keys.stream()
            .map(ReplaceMap::escapeRegex)
            .collect(Collectors.joining("|")));
    }

    public String replace(String input, Map<String,String> subs) {
        Matcher m = p.matcher(input);
        StringBuilder out = new StringBuilder();
        int i = 0;
        while(m.find()) {
            out.append(input.substring(i, m.start()));
            String key = m.group(0);
            out.append(subs.get(key));
            i = m.end();
        }
        out.append(input.substring(i));
        return out.toString();
    }

    // from https://stackoverflow.com/a/25853507/12299000
    private static Pattern SPECIAL_REGEX_CHARS = Pattern.compile("[{}()\\[\\].+*?^$\\\\|]");
    private static String escapeRegex(String s) {
        return SPECIAL_REGEX_CHARS.matcher(s).replaceAll("\\\\$0");
    }
}