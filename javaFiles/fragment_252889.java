@GetMapping
public String showDesignForm(Model model) {
    addIngredientsToModel(model);
    model.addAttribute("design", new Taco());
    return "design";
}