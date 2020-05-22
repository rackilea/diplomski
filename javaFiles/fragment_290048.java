@RequestMapping(value = "/apitest", method = RequestMethod.GET)
public @ResponseBody void testingAPI(@RequestHeader("APIKey") String apiKey) throws ParseException {
    final RestTemplate restTemplate = new RestTemplate();
    final String response = restTemplate.getForObject("url", String.class);
    System.out.println(response);
}