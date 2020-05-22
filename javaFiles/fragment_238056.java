@RestController
public class CreatingRepo {

    @RequestMapping("/")
    public void postMessage(SomeRepo repo) {
        // instead of the BeanFactory and using new SomeRepo you can get it like this.
    }
}