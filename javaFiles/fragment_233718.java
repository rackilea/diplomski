@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity login(@Valid @ModelAttribute LoginForm loginForm, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        // save to DB here
        userService.saveUsernameIfNotDuplicate(...);

        return new ResponseEntity(HttpStatus.OK);
    }
}