@Controller
public class HomeController{

    //might need @Qualifier if more than one implementation
    @Autowire
    private MyTest test; 

    @RequestMapping("/")
    public String home(){
        test.draw();
        return "homePage";
    }
}