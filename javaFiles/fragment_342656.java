public class ProductModel {
    public static Product createProduct(ProductType productType, String comment) {
        return createProduct(productType, comment, Application.getSessionTrackingId());
    }

    public static Product createProduct(ProductType productType, String comment, Long sessionTrackingId) {
        // Here now need sessionTrackingId Long
        // But this method is never called
        ....
    }
}