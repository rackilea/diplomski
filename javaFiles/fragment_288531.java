@RequestMapping(value={"/StudentForm"},method=RequestMethod.GET)
    public ModelAndView studentForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("student",new Student());
        modelAndView.setViewName("StudentForm");
        return modelAndView;
    }