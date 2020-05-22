import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {
    private static final String template = "Hello, %s!";

    @RequestMapping("/greeting")
    public ResponseEntity<String> greeting(@RequestParam(value="name", defaultValue="World") String name){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("thisiskey", "this is value");
        return new ResponseEntity<>(name, headers, HttpStatus.ACCEPTED);
    }
}