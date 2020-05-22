@RequestMapping(value = "/toggleB", method = RequestMethod.POST, headers = "Accept=application/json")
public ResponseEntity<java.lang.String> sendCommand(@RequestBody String ident) {

    // Do your stuff

    return new ResponseEntity<String>("Some response data/message",new HttpHeaders(), HttpStatus.OK);
}