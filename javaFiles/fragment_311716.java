@ControllerAdvice
public class CategoriesAdvice {

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("categories", getCategories());
    }
}