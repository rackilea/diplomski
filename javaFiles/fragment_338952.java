public Product removeProduct(int id) {
    Iterator<Product> iterator = productList.iterator();
    Product found = null;

    while(iterator.hasNext()) {
        Product product = iterator.next();
        if(product.getId() == id) {
            found = product;
            iterator.remove(); // remove on the fly
        }
    }

    // return pointer to removed product
    // Note: it can be NULL
    return found;
}