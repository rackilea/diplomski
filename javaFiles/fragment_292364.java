// Get all with request parameters
Map<String, String> params = new HashMap<>();
params.put("per_page","100");
params.put("offset","0");
List products = wooCommerce.getAll(EndpointBaseType.PRODUCTS.getValue(), params);

System.out.println(products.size());