@RestController("/customers")
public class CustomerServiceController {

    @GetMapping("/{id}")
    public String getId(@PathVariable("id") String id) {
        return "Customer";
    }
}