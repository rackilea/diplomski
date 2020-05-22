public class CustomHomeController {

    @RequestMapping(value = { "/customHome" }, method = RequestMethod.GET)
    public String landingPage(ModelMap model) {
        fill(model);

        // Here "home" refers to a view name e.g. as Freemarker template
        return "home";
    }
}