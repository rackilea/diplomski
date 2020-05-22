import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

@RestController
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    private ExecutorService executorService = Executors.newFixedThreadPool(10);
    private Map<String, String> results = new ConcurrentHashMap<>();

    @RequestMapping(path = "put/{key}", method = RequestMethod.POST)
    public ResponseEntity<Void> put(@PathVariable String key) {
        executorService.submit(() -> {
            try {
                //simulate a long running process
                Thread.sleep(10000);
                results.put(key, "success");
            } catch (InterruptedException e) {
                results.put(key, "error " + e.getMessage());
                Thread.currentThread().interrupt();
            }
        });
        return new ResponseEntity<>(CREATED);
    }

    @RequestMapping(path = "get/{key}", method = RequestMethod.GET)
    public ResponseEntity<String> get(@PathVariable String key) {
        final String result = results.get(key);
        return new ResponseEntity<>(result, result == null ? NOT_FOUND : OK);
    }
}