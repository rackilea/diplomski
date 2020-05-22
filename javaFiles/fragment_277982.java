@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
                   public String addStudent(@ModelAttribute("studentModel")Student student, 
                   ModelMap model) {
                      model.addAttribute("name", student.getName());
                      model.addAttribute("age", student.getAge());
                      model.addAttribute("id", student.getId());
//hope you have a result.jsp if you don't then return the name of your desired page
                      return "result";
                   }