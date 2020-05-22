@RequestMapping(method=RequestMethod.GET)
@ResponseBody
public String getJson() {
    Map<String, Object> theMap = new LinkedHashMap<>();
    // if you don't care about order just use a regular HashMap

    // put your objects in the Map with their names as keys
    theMap.put("someObject", someModelObject);

    // write the map using your code
    ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

    return ow.writeValueAsString(theMap);
}