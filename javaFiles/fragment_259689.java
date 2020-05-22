public class NgramModel {

    //one `ngram`
    private HashMap<String,Integer> ngram; 

    public NgramModel() {
        //reference the `ngram` from above
        ngram = new HashMap <String, Integer>();
        ngram.put("aa", 2);
    }
}