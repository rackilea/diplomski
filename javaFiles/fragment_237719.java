@PostMapping(path = { "/user/executeSQL" })
public ResponseEntity<Object> executeSQL(@RequestBody String tmp) {
    String[] split = tmp.replace("\n", "").replace("\t", "").split(";");
    Map<String,String> response = new HashMap<String, String>();
    response.put("feedback", databaseTableService.executeSQL(split));
    return new ResponseEntity<>( response , HttpStatus.OK);
}