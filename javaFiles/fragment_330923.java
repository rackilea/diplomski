public abstract class AbstractController<T> {
    @RequestMapping(method=RequestMethod.POST) 
    public String mainPost(@Valid T myObject,
          BindingResult result, Model model) { ... } 
}

@Controller 
@RequestMapping("/myclass")
public class MyClassController extends AbstractController<MyClass> { ... }