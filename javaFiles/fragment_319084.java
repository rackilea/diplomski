@RequestMapping(value="/hello", method = RequestMethod.GET)
public ModelAndView product_save(){
    ModelAndView model = new ModelAndView();
    model.setViewName("hello"); // HTML page name
    return model;
}