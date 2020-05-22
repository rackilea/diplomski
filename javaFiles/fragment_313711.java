@RequestMapping(value="/product/show",method= RequestMethod.GET)
    public String listProducts(Model model){
        User user = userService.getCurrentlyAuthenticatedUser();
        model.addAttribute("product", new ProductBasic());
        model.addAttribute("listProducts",this.productBasicService.listProduct(user));
}