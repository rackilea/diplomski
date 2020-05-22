public Product getProductsById(String productId) {
            Product productById = null;
            for (Product product : listOfAllProducts) {
                if (product != null && product.getProductId() != null && product.getProductId().equals(productId)) {
                    productById = product;
                    break;
                }              
            }
            if (productById == null)
                    throw new IllegalArgumentException("no product found " + productId);

           return productById;

}