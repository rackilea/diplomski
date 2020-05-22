@Controller
@RequestMapping("/success")
public class SuccessController {

    @RequestMapping(value = "/eventlogs/logs", method = RequestMethod.POST)
    public String logs(HttpServletRequest req) {
        System.out.println("Received POST request:" + req.getParameter("..."));
....
        return "success";
    }
}