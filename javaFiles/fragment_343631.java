List<Product> products = new ArrayList<>();
products.add(new Product("iphone", 70000, 1));
products.add(new Product("nokia", 2000, 3));
ModelAndView model = new ModelAndView("demo");
model.addObject("products", products);
return model;