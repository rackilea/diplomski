@Controller
public class CustomArgumentController {

@ModelAttribute
void beforeInvokingHandlerMethod(HttpServletRequest request) {
    request.setAttribute("foo", "bar");
}


@RequestMapping(value="/data/custom", method=RequestMethod.GET)
public @ResponseBody String custom(@RequestAttribute("param1") String param1 ) {
    // Here, I will have value of param1 as test in String object which will be mapped my Spring itself
}