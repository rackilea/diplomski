public class Main {
    public static void main(final String[] args) throws Exception {
        final String tagged = "World_NN Big_RBS old_RB stupid_JJ";

        int nouns = 0;
        int adjectives = 0;
        int adverbs = 0;

        final String[] tokens = tagged.split(" ");

        for (final String token : tokens) {
            final int lastUnderscoreIndex = token.lastIndexOf("_");
            final String realToken = token.substring(lastUnderscoreIndex + 1);
            if ("NN".equals(realToken)) {
                nouns++;
            }
            if ("JJ".equals(realToken)) {
                adjectives++;
            }
            if ("RB".equals(realToken) || "RBS".equals(realToken)) {
                adverbs++;
            }
        }

        System.out.println(String.format("Nouns: %d Adjectives: %d, Adverbs: %d", nouns, adjectives, adverbs));
    }
}