@FunctionalInterface
interface ProductFactory<T extends BaseProduct> {
    T create(String brand, 
             String productName, 
             BigDecimal price, 
             int totalQuantity, 
             int defectiveQuantity, 
             List<Review> reviews);
}