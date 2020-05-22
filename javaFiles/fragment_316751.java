import io.vavr.collection.List;
@RestController
class TestController {

    @GetMapping("/test")
    List<String> testing() {
        return List.of("test", "test2");
    }
}