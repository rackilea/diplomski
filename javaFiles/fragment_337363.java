public void updateProduct(Product product) throws ProductNotFoundException {

    Iterator<Product> it = allProducts.iterator();
    Product p = null;
    if (!allProducts.isEmpty()) {
        while (it.hasNext()) {
            p = it.next();
            if (p.getId() == product.getId()) {
                p.setPrice(product.getPrice());
                System.out.println("Successfully updated the product "
                        + product.getId());
                return;
            }
        }
    } 
    throw new ProductNotFoundException(product.getName());
}