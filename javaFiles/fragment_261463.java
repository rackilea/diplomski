@RestController
public class MyController {
    @GetMapping("/test")
    public void getWithTransformedPrincipal(@AuthenticationPrincipal Principal principal) {
        GenericPrincipal generic = PrincipalTransformer.transform(principal);
        doSomethingWithPrincipal(generic);
    }
}