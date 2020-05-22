@RequestMapping(value = "/index", method = RequestMethod.GET)
public ModelAndView homePage() {
   ModelAndView model = new ModelAndView();
   model.addObject("newUser", new User());
   model.setViewName("index");
   return model;
}