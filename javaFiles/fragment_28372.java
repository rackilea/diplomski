import javax.net.ssl.SSLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class HelloworldApplication {

    @RestController
    class HelloworldController {
        @GetMapping("/") //this will serve get
        String hello() throws SSLException {
            //this will land in Spring error message text
            throw new SSLException("Tested exception javax.net.ssl");
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloworldApplication.class, args);
    }
}