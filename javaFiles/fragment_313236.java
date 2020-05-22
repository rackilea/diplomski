public static void main(String[] args) throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    ProductList list = mapper.readValue("{\"_id\" : \"1234AG567\",\"products\" : {\"1234\":{\"product_name\" : \"xyz\",\"product_type\" : \"abc\"},\"3456\":{\"product_name\" : \"zzz\",\"product_type\" : \"def\"}}}", ProductList.class);
    System.out.println(list.getId());
    System.out.println(list.getProducts());
}