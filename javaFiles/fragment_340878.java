public void updateProduct(Product updatedProduct) {
    Product existingProduct = /*find existing product*/;
    nullAwareBeanCopy(existingProduct, updatedProduct);
    // or 
    myCopyProperties(updatedProduct, existingProduct);
}