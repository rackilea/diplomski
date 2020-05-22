public class ProductWithCustomTags {
    private static final long serialVersionUID = 1L;
    private final B2BProductData productData;
    public Boolean useMapPriceOtherwiseMEPrice;
    public String category03;
    public String category02;
    public String category01;
    public ProductWithCustomTags(B2BProductData d) {
        productData = d;
    }
    public B2BProductData getProductData() {
        return productData;
    }
}