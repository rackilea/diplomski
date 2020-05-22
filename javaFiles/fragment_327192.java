@RestController
@RequestMapping("/public/login")
public class LoginService {

    @Autowired
    CustomAuthenticationProvider provider;

    @GetMapping
    public String loginTest(){
        return "Login OK";
    }

    @GetMapping("/{username}/{password}")
    public ResponseEntity<Map<String, String>> login(@PathVariable String username,@PathVariable String password ,HttpServletRequest request)
    {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
        Authentication authenticate = provider.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        request.getSession().setAttribute("username", username);
        Map<String, String> result = new HashMap<>();
        result.put(username, new String(Base64.getEncoder().encode(password.getBytes())));
        ResponseEntity<Map<String, String>> finalResult = new ResponseEntity<>(result,HttpStatus.OK);
        return finalResult;
    }
}