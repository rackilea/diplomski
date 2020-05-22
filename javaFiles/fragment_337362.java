if (!allProducts.isEmpty()) {
        //Code
} else {
        System.out.println("No such product " + product.getId());
        throw new ProductNotFoundException(product.getName());
}