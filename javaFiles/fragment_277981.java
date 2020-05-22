@RequestMapping(value = "/addStudent",method = RequestMethod.GET)
    public ModelAndView initView() {
        Student studentModel = new Student();

        return new ModelAndView("Student", "studentModel", studentModel );
    }