public List<String> getProducts() {
        return productService.getProductCategories();
    }

public List<String> getProducts(String category) {
        return productService.getProducts(category);
    }