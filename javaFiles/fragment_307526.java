@Controller
public class ErrorPageController {

    @RequestMapping("/errorPage")
    @ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
    public String showErrorPage(){
        return "errorPage";
    }
}