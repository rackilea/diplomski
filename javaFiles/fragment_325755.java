public class MyCtrl {
  @ModelAttribute(„foo“)
  public Foo initFoo(Request or params) {
     return builtFoo;
  }

  @RequestMapping(...)
  public String submit(@ModelAttribute(„foo“) Foo foo) {
    // use the inited and merged foo parameter
    return templateName;
  }
}