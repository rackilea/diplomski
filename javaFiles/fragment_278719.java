public class Example {
    private static StanfordCoreNLP pipeline;
    private static Env env;

    static {
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
        Annotation document = new Annotation(string);

        // use the pipeline to annotate the document we created
        pipeline.annotate(document);
        List<CoreMap> sentences = document.get(SentencesAnnotation.class);

        CoreMapExpressionExtractor extractor = CoreMapExpressionExtractor.createExtractorFromFiles(env, "./app/utils/Summarizer/mapping/career_objective.rule", "./app/utils/Summarizer/mapping/personal_info.rule", "./app/utils/Summarizer/mapping/education.rule", "./app/utils/Summarizer/mapping/work_experience.rule", "./app/utils/Summarizer/mapping/certification.rule", "./app/utils/Summarizer/mapping/publication.rule", "./app/utils/Summarizer/mapping/award_achievement.rule", "./app/utils/Summarizer/mapping/hobbies_interest.rule", "./app/utils/Summarizer/mapping/lang_known.rule", "./app/utils/Summarizer/mapping/project_details.rule", "./app/utils/Summarizer/mapping/skill-set.rule", "./app/utils/Summarizer/mapping/misc_header.rule");

        boolean flag = false;
        for (CoreMap sentence : sentences) {
            List<MatchedExpression> matched = extractor.extractExpressions(sentence);
            //System.out.println("Probable Header is : " + matched);
            Set<String> uniqueMatchedKeyWordSet = DocumentParserUtil.removeDuplicate(matched);
            System.out.println("Matched: " + uniqueMatchedKeyWordSet + " and Size of MatchedSet: " + uniqueMatchedKeyWordSet.size());

            // checked if the more than half the no. of word in header(string) is matched
            if ((matched.size() >= uniqueMatchedKeyWordSet.size()) && !matched.isEmpty() && matched.size() >= Math.floorDiv(string.split("\\s").length, 2)) {
                flag = true;
            } else {
                flag = false;
            }

        }

        return flag;
    }

}