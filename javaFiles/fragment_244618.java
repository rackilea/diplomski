public List<Product> search(){
    List<Product> products = new ArrayList<Product>();
    ResultSet rs = DAO.fetch("SELECT * FROM Products");
    while (rs.next()) {
        Product product = new Product();
        product.setNumber(rs.getString("ProductNumber"));
        product.setName(rs.getString("ProductName"));
        product.setQty(rs.getString("ProductQty"));
        products.add(product);
    }
    return products;
}