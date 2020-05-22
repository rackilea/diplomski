import javax.validation.constraints.Email;
//...

@Controller
@Validated // With this guy, now validation works well.
public class FooConroller {

    @PostMapping("/foo")
    public String foo(Optional<@Email String> email) {
        //Now it works as expected.
        return "foo";
    }

}