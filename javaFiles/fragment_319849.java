@RestController
public class mainController {
@RequestMapping(value = "/post", method = RequestMethod.POST,
        consumes = MediaType.APPLICATION_JSON,
        produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
public ResponseEntity<Object> postUser(@RequestBody User user){
System.out.println(user);
return new ResponseEntity<>("Success", HttpStatus.OK);
}

@RequestMapping(value = "/get", method = RequestMethod.GET)
public User getStr(){
    System.out.println("-------------------------");
    return new User("Tom", 56); //'Get' Check
}

}