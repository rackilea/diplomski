@RequestMapping(method = RequestMethod.POST, produces = "application/json; charset=utf-8")
public @ResponseBody Map<String, String> getTest(@RequestBody Map<String, Long> params) {

    Map<String, String> response = new HashMap<>();

    response.put("name", "My Service");

    return response;
}