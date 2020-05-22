@Controller 
@RequestMapping("/YourPath")
public class YourController {
    @RequestMapping(method = RequestMethod.POST)
    public String processThePost(...many options to receive params from the request...) {

        // process the parameters

        return "redirect:/someFrontEndServlet";
    }
}