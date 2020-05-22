public class ContentProvider {

    public static List<Product> getProducts() {
        return getContent(42, Product.class);
    }

    private static <T> List<T> getContent(int id, Class<T> contentType) {
        // Generic content retrieval.
    }

}