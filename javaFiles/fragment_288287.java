@PostMapping("/saveProduct")
public String saveProduct(@Valid @ModelAttribute("product") QaRaised theProduct, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
        return "product-form";
    }
    qaRaisedService.saveProduct(theProduct);
    return "redirect:/products/qaraised";
}