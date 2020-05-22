@RequestMapping(value = "/user", params="userID", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<User> getUser(@RequestParam("userID") int id) {
    System.out.println("Fetching User with id " + id);
    User user = userService.findById(id);
    if (user == null) {
        System.out.println("User with id " + id + " not found");
        return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<User>(user, HttpStatus.OK);
}

@RequestMapping(value = "/user", params="emailID, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE")
public ResponseEntity<User> getUserByEmail(@RequestParam("emailID") String email) {
    System.out.println("Fetching User with email " + email);
    User user = userService.findByEmail(email);
    if (user == null) {
        System.out.println("User with email " + email + " not found");
        return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<User>(user, HttpStatus.OK);
}