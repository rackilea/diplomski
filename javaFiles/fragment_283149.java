public final class MultiPatternSpliterator
extends Spliterators.AbstractSpliterator<MatchResult> {
    public static Stream<MatchResult> matches(String input, String... patterns) {
        return matches(input, Arrays.stream(patterns)
                .map(Pattern::compile).toArray(Pattern[]::new));
    }
    public static Stream<MatchResult> matches(String input, Pattern... patterns) {
        return StreamSupport.stream(new MultiPatternSpliterator(patterns,input), false);
    }
    private Pattern[] pattern;
    private String input;
    private int pos;
    private PriorityQueue<Matcher> pendingMatches;

    MultiPatternSpliterator(Pattern[] p, String inputString) {
        super(inputString.length(), ORDERED|NONNULL);
        pattern = p;
        input = inputString;
    }

    @Override
    public boolean tryAdvance(Consumer<? super MatchResult> action) {
        if(pendingMatches == null) {
            pendingMatches = new PriorityQueue<>(
                pattern.length, Comparator.comparingInt(MatchResult::start));
            for(Pattern p: pattern) {
                Matcher m = p.matcher(input);
                if(m.find()) pendingMatches.add(m);
            }
        }
        MatchResult mr = null;
        do {
            Matcher m = pendingMatches.poll();
            if(m == null) return false;
            if(m.start() >= pos) {
                mr = m.toMatchResult();
                pos = mr.end();
            }
            if(m.region(pos, m.regionEnd()).find()) pendingMatches.add(m);
        } while(mr == null);
        action.accept(mr);
        return true;
    }
}