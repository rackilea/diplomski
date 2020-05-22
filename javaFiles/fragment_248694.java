public ModelAndView myController() {
    Model model = new Model();
    model.put(...); 
    try {
       ...
       return new ModelAndView("success", model);
    } catch (SomethingWrongException e) {
       return new ModelAndView("failure", model);   
    }        
}