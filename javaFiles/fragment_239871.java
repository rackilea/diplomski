@PutMapping("/createUser")
public ResponseEntity<String> createUser(@RequestBody User user) {
    User thisValue = repository.findByUsername(user.getUsername());
    if (thisValue != null) {
        return new ResponseEntity<String>("account-exist", HttpStatus.BAD_REQUEST);
    }else{
        return new ResponseEntity<String>("reached here", HttpStatus.OK);
    }
}