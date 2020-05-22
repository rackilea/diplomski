@Controller
public class CustomErrorController implements ErrorController {

private static final String PATH = "/error";

@RequestMapping(value = PATH)
public ResponseEntity<String> error(WebRequest webRequest, HttpServletResponse response) {
    return ResponseEntity.badRequest().body("");

}

@Override
public String getErrorPath() {
    return PATH;
     }

}