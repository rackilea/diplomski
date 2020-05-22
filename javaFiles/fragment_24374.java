@RestController
public class MyServlet {

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setDisallowedFields("somefield");
    }

    @GetMapping("/myservlet")
    public String myservlet(Model model) {
        return model.toString();
    }
}