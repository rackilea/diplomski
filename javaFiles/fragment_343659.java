@GetMapping("/show/products")
public String getProduct(Model model,
    @ModelAttribute("myFormObject") MyFormObject myFormObject,
    BindingResult result) {
    List<Product> products = this.productService.getAllProducts(myFormObject.getPName());
    model.addAttribute("products", products);
    return "show_product";
}