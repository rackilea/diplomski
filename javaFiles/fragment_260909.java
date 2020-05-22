@InitBinder
 public void initBinder(WebDataBinder binder) {

  binder.registerCustomEditor(Product.class,
    new CaseInsensitivePropertyEditor());
 }