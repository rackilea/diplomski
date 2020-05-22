// CREATE A USER
@PostMapping("/register")
public @ResponseBody ResponseEntity<JSONObject> createUser( @RequestBody User user ) {

    JSONObject responseJson = new JSONObject();

    if (userService.userExists(user)) {

        responseJson.put("status", "User with that username already exists.");

        return new ResponseEntity<JSONObject>(responseJson, HttpStatus.BAD_REQUEST);
    }

    responseJson.put("status", "User created.");

    return new ResponseEntity<JSONObject>(responseJson, HttpStatus.OK);
}