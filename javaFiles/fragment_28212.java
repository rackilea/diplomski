public Product find(String input) {
    for (Product product : this.products) {
        if (input.equals(product.getName())) {
            return product;
        }   
    }   
    return null;
}