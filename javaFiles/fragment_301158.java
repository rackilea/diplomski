@ControllerAdvice
class Advice {

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("orgId", "value1");

    }
}