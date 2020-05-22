public ResponseEntity<Order> orderDetails (@RequestBody Order order){

   String username = "username";
   String password = "password";
   HttpHeaders headers = new HttpHeaders();
   headers.setBasicAuth(username, password);

   // request url
   String url = "https://test.myshopify.com/admin/orders/2013413015655.json";

   RestTemplate restTemplate = new RestTemplate();

   HttpEntity request = new HttpEntity(headers);

   ResponseEntity<Order> response = restTemplate.exchange(
           url, HttpMethod.GET, request, Order.class);


   return response;
}