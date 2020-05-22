public Product getTotalAsProduct(Set<Product> set) {
    Product newProduct = null;
    Optional<Product> findProduct = set.stream().findFirst();
    if(findProduct.isPresent()) { //No sense in making an object if set is empty
        //Create a new Product with the same id, name, brand
        newProduct = findProduct.get().clone(); //If Cloneable, OR create a constructor that takes a Product and makes a new one, OR make a new Product() and get/set as needed
        long totalAmount = set.stream().mapToInt(Product::getAmount).sum();
        newProduct.setAmount(totalAmount);
    }
    return newProduct; //Null if set was empty
}