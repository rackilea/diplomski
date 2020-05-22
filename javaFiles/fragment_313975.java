private void initProducts() {
    ProductOption productOpton1=new ProductOption("mit Cocktailsauce", new BigDecimal(0), null, null, null, null);
    ProductOption productOpton2=new ProductOption("mit Joghurtsauce", new BigDecimal(0), null, null, null, null);
    ProductOption productOpton3=new ProductOption("ohne Sauce", new BigDecimal(0), null, null, null, null);

    Product product37= new Product("Falafel", ProductCategory.Vegatarische_Döner, "Wahl aus: mit Cocktailsauce, mit Joghurtsauce oder ohne Sauce.",  new BigDecimal(5.00));

    product37.getProductOptions().add(productOpton1);
    product37.getProductOptions().add(productOpton2);
    product37.getProductOptions().add(productOpton3);

    productOpton1.setProduct(product37);
    productOpton2.setProduct(product37);
    productOpton3.setProduct(product37);

    this.productRepository.save(product37);
}