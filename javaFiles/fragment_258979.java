@Controller
@RequestMapping("/path")
public class MyController {
    @RequestMapping(value = "/search/again.do", method = RequestMethod.GET, produces = {
    "application/json"
    })
    public ResponseEntity<?> find(@RequestParam(value = "test", required = false) final String test) {
        if (test == null) {
            return new ResponseEntity<String>("test parameter is missing", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<String>("Success ", HttpStatus.OK);
        }
    }
}