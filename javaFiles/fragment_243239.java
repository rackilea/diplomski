@RequestMapping(value="/nextPage",method=RequestMethod.POST)
    public String FicheService(@ModelAttribute CMDBean cmd,BindingResult result,@RequestParam("nom") String nom, @RequestParam("ppr") Integer ppr,ModelMap model){
    model.addAttribute("ppr", ppr);
    model.addAttribute("nom", nom);


}