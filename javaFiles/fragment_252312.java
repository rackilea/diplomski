@Controller
public class Hello {

    @RequestMapping(value="/test.htm")
    public String test(Model uiModel){
        uiModel.addAttribute("yourkey", "Hello World"); // put some data
        return "Hello"; // means "open Hello.jsp"
    }
}