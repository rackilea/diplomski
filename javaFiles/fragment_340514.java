@Controller
class UserController {


    @GetMapping("/self")
    public ResponseEntity<User> demo(@AuthenticationPrincipal User user){
        return new ResponseEntity<>(user, HttpStatus.OK);
    }