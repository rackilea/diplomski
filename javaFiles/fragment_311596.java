@ControllerAdvice
public class GlobalDataAdvice {

  @Autowired
  private FooService fooService;

  @ModelAttribute("foo")
  Foo getFoo(){
        return fooService.find(...);
  }  
}