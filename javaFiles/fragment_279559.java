@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class Users {

    @RequestMapping(
            value = "/edit",
            method = RequestMethod.PUT)
    public ResponseEntity<?> create(@RequestBody User user){
         ....
         ....
    }

    @RequestMapping(
            value = "/**",
            method = RequestMethod.OPTIONS
    )
    public ResponseEntity handle() {
        return new ResponseEntity(HttpStatus.OK);
    }
}