@Controller
@RequestMapping("/ajax")
public void class AjaxController {
   @RequestMapping("/foo")
   public String foo() {
       return "ajax.foo";
   }
}

@Controller
@RequestMapping("/")
public void class AppController {
   @RequestMapping("/foo")
   public String foo() {
       return "foo";
   }
}