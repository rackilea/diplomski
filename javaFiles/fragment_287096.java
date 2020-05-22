@RestController
public class FooController {

    @GetMapping("/foo")
    public Foo getFoo(@RequestParam("include") List<String> includes) {
        return new Foo(includes);
    }

}