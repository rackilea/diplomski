package com.mycompany.web_shop.controller;
@Controller
public class ProductsController {

  @Autowired
  AllproductsDao allproductsDao;

  @RequestMapping("/products")
  public String listProducts(ModelMap model) {
    List<Allproducts> products = allproductsDao.find();
    model.addAttribute("products", products);
    return "products";
  }
}