ResponseEntity(T body, MultiValueMap<String,String> headers, HttpStatus statusCode)

ResponseEntity<String> response = 
    new ResponseEntity(gson.toString(),
    new MultiValueMap(), 
    HttpStatus.OK);