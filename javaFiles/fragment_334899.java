public class MyCustomSimilarity extends PerFieldSimilarityWrapper {
    @Override
    public Similarity get(String fieldName) {
        if (fieldName.equals("author")) {
            return new CustomAuthorSimilarity();
        }
        else {
            return new DefaultSimilarity();
        }
    }
}