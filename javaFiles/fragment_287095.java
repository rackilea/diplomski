@FeignClient(value = "foo-client")
public interface FooClient {

    @GetMapping("/foo")
    Foo getFoo(@RequestParam("include") List<String> includes);

}