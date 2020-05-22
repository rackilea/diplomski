String products= "[{\"product_id\": \"123\",\"name\":\"stack\"},{\"product_id\": \"456\",\"name\":\"overflow\"}]";
List<ProductInformation> productInfoList = new JSONDeserializer<List<ProductInformation> >()
    .use(null, ArrayList.class)
    .use("values",ProductInformation.class)
    .deserialize(products);

for(ProductInformation productInformation : productInfoList){
    System.out.println(productInformation.getProduct_id();
}