@Controller
@RequestMapping("/")
public class PublicPagesController extends BaseController {
    @RequestMapping("**/favicon.ico")
    public String favIconForward(){
        return "forward:/public/img/fav.ico";
    }

    // ...other stuff...
}