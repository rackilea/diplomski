public class Example {
    private static StanfordCoreNLP pipeline;
    private static Env env;

    public static init() {
        // creates a StanfordCoreNLP object.
        Properties props = new Properties();
        props.put("annotators", "tokenize, ssplit, pos, lemma, ner");

        RedwoodConfiguration.current().clear().apply();
        pipeline = new StanfordCoreNLP(props);

        env = TokenSequencePattern.getNewEnv();
        env.setDefaultStringMatchFlags(NodePattern.CASE_INSENSITIVE);
        env.setDefaultStringPatternFlags(Pattern.CASE_INSENSITIVE);
    }

    public static boolean isHeaderMatched(String string) {
        // code left out for brevity
    }

}