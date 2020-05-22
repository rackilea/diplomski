@RequestMapping(path = "/add")
public @ResponseBody String addFromTo () {

    String apikey = "";
    String baseurl = "http://demowebshop.webshop8.dk/admin/WEBAPI/v2/orders?start={start}&end={end}&api_key={apikey}";

    Map<String, Object> parameters = new HashMap<>();
    parameters.put("start", "2018-10-05T20:49:41.745Z");
    parameters.put("end", "2018-10-16T06:43:40.926Z");
    parameters.put("apikey", apikey);

    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    headers.setBasicAuth("", apikey);

    ResponseEntity<OrderResponse> response = restTemplate.getForEntity(baseurl, OrderResponse.class, parameters);

    return "Some text.";
}