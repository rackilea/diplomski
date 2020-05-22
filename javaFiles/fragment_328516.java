@RequestMapping(method = RequestMethod.POST)
public ResponseEntity<?> createCustomer(UriComponentsBuilder b) {

    UriComponents uriComponents = 
        b.path("/customers/{id}").buildAndExpand(id);

    return ResponseEntity.created(uriComponents.toUri()).build();
}