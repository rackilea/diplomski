@RequestMapping(value="/reportUpdate",method=RequestMethod.POST)
public ModelAndView updateUser(@ModelAttribute("User") @Validated User user,BindingResult results,RedirectAttributes redirectAttributes){

    ModelAndView modelAndView=new ModelAndView();
    //myValidationUtils.validate(user, results);
    if(results.hasErrors()){
        return new ModelAndView("Reports", "User", user);
    }
    if(user!=null){
        int result=reportsDAO.updateByCode(user);
        if(result!=-1){
            modelAndView.setViewName("redirect:/reports");
        }else{
            modelAndView.setViewName("Reports");
            modelAndView.addObject("message", "Unable to edit, Please try again.");
        }
    }else{
        modelAndView.setViewName("Reports");
        modelAndView.addObject("message", "Unable to edit, Please try again.");
    }

    return modelAndView;
}