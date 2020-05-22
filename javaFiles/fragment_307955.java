@RequestMapping(value = "/search/", method = RequestMethod.POST, headers = "Accept=application/json")
public ResponseEntity<String> getVertagFromSearch(@RequestBody String json, UriComponentsBuilder uriBuilder){
Contract contract = contract.fromJsonToContract(json);
    //do Stuff
    return new ResponseEntity<String>(Contract.toJsonArray(result), headers, HttpStatus.OK);
}