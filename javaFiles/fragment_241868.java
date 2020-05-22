ProductFactory<GroceryProduct> factory = 
    (String brand, String productName, BigDecimal price, int totalQuantity, int defectiveQuantity, List<Review> reviews) -> 
        new GroceryProduct(brand, 
                           productName, 
                           price, 
                           totalQuantity, 
                           defectiveQuantity, 
                           reviews);
input(factory, inputStream);