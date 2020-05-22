@RequestMapping(method = RequestMethod.POST)
public ResponseEntity<?> createCustomer(UriComponentsBuilder b) {

    UriComponents uriComponents = 
        b.path("/customers/{id}").buildAndExpand(id);

    HttpHeaders headers = new HttpHeaders();
    headers.setLocation(uriComponents.toUri());
    return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
}