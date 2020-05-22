@Controller
@RequestMapping("/foo")
public class MyController {

    @RequestMapping
    public void method1(/* anything you want Spring MVC to get for you like form1 backing bean for example */) {
        // handling form1 submission
    }

    // form action attribute must have a "bar2" query param somewhere
    @RequestMapping(params = "bar2") 
    public void method2(/* anything regarding form2 this time */) {
        // handling form2 submission
    }

    @RequestMapping(params = "bar3") 
    public void method3(/* anything regarding form3 this time */) {
        // handling form3 submission
    }
}