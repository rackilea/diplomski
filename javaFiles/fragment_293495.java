while (result.next()) {

    Product product = new Product();

    product.setTotal(result.getDouble("Total"));
    product.setName(result.getString("Name"));
    // etc.

    productList.add(product);
}