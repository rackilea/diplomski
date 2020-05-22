@DeleteMapping(path = {"/{name}", "/{id}")
public ResponseEntity<Object> clearUser(@PathVariable("name") Optional<String> name, @PathVariable("id") Optional<Integer> id){
    myService.deleteByIdOrName(id, name);
    return new ResponseEntity<>(HttpStatus.OK);
}

  MyRepo ...
  void deleteByIdOrName(Optional<Integer> id, Optional<String> name);

  MyService
  void deleteByIdOrName(Optional<Integer> id, Optional<String> name) {
      repo.deleteByIdOrName(id, name);
  }