@RequestMapping(value = "/createPerson/", method = RequestMethod.POST)
public ResponseEntity<Void> createSep(@RequestBody final String DTOJsonObject,
    UriComponentsBuilder ucBuilder) {
    ObjectMapper mapper = new ObjectMapper();
    Map<String, Object> parsedData;

    parsedData = mapper.readValue(DTOJsonObject, HashMap.class);

    List<String> listIDS = (ArrayList<String>)parsedData.get("listOfIds");

    for(String n : listIDS){
        System.out.println(n);
    }