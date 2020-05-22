@RestController
public class TestController {
@Autowired
AppConfig config;

@Autowired
FilterConfig filterConfig;

@GetMapping("/admin/hello")
String test() {
    return "hello test";
}

@GetMapping("/alternative/hello")
String test2() {
    return "hello test 2";
}

@GetMapping("/admin/addNewPort")
ResponseEntity<String> createNewPort(@RequestParam Integer port, @RequestParam String context) {
    if (port == null || port < 1) {
        return new ResponseEntity<>("Invalid Port" + port, HttpStatus.BAD_REQUEST);
    }
    config.addPort("http", "localhost", port, false);
    if (context != null && context.length() > 0) {
        config.addContextAllowed(filterConfig, port, context);
    }

    return new ResponseEntity<>("Added port:" + port, HttpStatus.OK);
}

@GetMapping("/admin/removePort")
ResponseEntity<String> removePort(@RequestParam Integer port) {
    if (port == null || port < 1) {
        return new ResponseEntity<>("Invalid Port" + port, HttpStatus.BAD_REQUEST);
    }
    config.removePort(port);

    return new ResponseEntity<>("Removed port:" + port, HttpStatus.OK);
 }
}