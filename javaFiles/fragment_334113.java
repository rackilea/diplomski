@Scope("request")
@RestController
public class GetOperatorSeries{
@RequestMapping(value = "test", method = RequestMethod.GET)
    public String getOperatorSeries(HttpServletResponse response, @RequestParam(value = "mobno") long mobno,
            @RequestParam(value = "sourceType", required=false) String sourceType,
            @RequestParam(value = "responseType") String responseType, Model model)
{

    if (sourceType == null) {
     model.addAttribute("errorMessage", "Source Type is missing");
     return "viewName"; // Now show the error message in view. You can also add this error as flash attribute. You can also show a new error page.


    }

}