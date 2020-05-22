@RequestMapping(value="/loginiscorrect",method=RequestMethod.POST)
public String LoginUser(@Validated(LoginGroup.class) kisitablo kisitablo, BindingResult result,HttpServletRequest request,HttpServletResponse response) {
    if (result.hasErrors()) {
        return "login";
    }
    //Your logic.....
}