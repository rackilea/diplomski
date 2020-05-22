@RequestMapping(value = { "/books/store/product",
                  "/books/store/product/"}, method = { RequestMethod.POST })
    public String saveProduct(@ModelAttribute("productForm") ProductForm productForm,
            HttpServletRequest request, Model model) throws Exception {

..
}

 @RequestMapping(value = { "/books/store/product/{productId}",
                  "/books/store/product/{productId}/" }, method = { RequestMethod.POST })
    public String saveProduct(@ModelAttribute("productForm") ProductForm productForm, 
                              @PathVariable Long productId,
            HttpServletRequest request, Model model) throws Exception {

..
}