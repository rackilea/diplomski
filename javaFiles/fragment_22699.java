@RequestMapping(value = "/populate/someObject", method = RequestMethod.PUT, headers = "Accept=application/json", produces = {
        "application/json; charset=UTF-8" })
@ResponseBody
public ResponseEntity<String> getPopulateAndReturn(@RequestBody String json) {
    JsonService jsonService = new JsonService();
    MyClass obj = populateThis(jsonService.convertJsonInputToJsonObject(json));
    Gson gson = new Gson();
    return new ResponseEntity<String>(gson.toJson(obj), HttpStatus.OK);
}