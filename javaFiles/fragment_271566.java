public class MainClass {

    public static void main(String [] args)
    {
        List<String> sentences = new ArrayList<String>();
        sentences.add("Pulkit likes StackOverflow and coding");
        sentences.add("Pulkit does not like Reddit");
        sentences.add("Pulkit like ice cream");

        List<String> queries = new ArrayList<String>();
        queries.add("Pulkit coding");
        queries.add("like");
        queries.add("does");

        findMatch(sentences, queries);
    }

    public static void findMatch(List<String> sentences, List<String> queries) {
        for(String query : queries) {
            System.out.print("]");

            String match = ".*\\b" + query.replace(" ", "\\b.*") + "\\b.*";             
            for (int iSentence = 0; iSentence < sentences.size(); iSentence++) {
                if(sentences.get(iSentence).matches(match)) {
                    System.out.print(" " + iSentence);
                }
            }

            System.out.println("");
        }
    }
}