@RequestMapping(method = RequestMethod.GET)
//remove @ResponseBody
public String ABC(Registratio registration, ModelMap modelMap,
    HttpServletRequest request,HttpServletResponse response){
    if(somecondition=="false"){
        // here i am returning only the string 
        // in this case, render response yourself and just return null 
        response.getWriter().write("notok");
        return null;
    }else{
        // redirect
        return "redirect:checkPage";
    }
}