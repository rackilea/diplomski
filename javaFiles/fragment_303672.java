@RequestMapping(value = "/loadPOAction", method = RequestMethod.POST)
public @ResponseBody OrderSearch loadOrder(HttpServletRequest request, @RequestBody OrderSearch search) {

  // set on search object if possible
  search.setName("my name which I retrieved from somewhere");

  // alternatively, you could create a map with the values you need and return it
  // (requires you to change the method return type to Map
  Map<String, Object> resultMap = new HashMap<>();
  resultMap.put("name", "my name");
  resultMap.put("incomingSearch", search);
  resultMap.put("someSearchValue", search.getSomeValue());

  // alternatively, create a new "OrderSearchResponse" class and return an instance of it
  OrderSearchResponse searchResponse = new OrderSearchResponse();
  searchReponse.setName("my name");
  searchResponse.setSomeValue("some value");

  return search; // or resultMap or searchReponse depending on what you do above
}