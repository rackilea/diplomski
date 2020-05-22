@RequestMapping(value="listagem/{pagina}/{items}/{ordem}")
@PreAuthorize("hasPermission(#user, 'listagem_'+#this.this.name)")
public ModelAndView listagem(@PathVariable("pagina") String pagina, @PathVariable("items") String items, @PathVariable("ordem") String ordem) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("privado/"+this.getName()+"/listagem");

    mav.addObject("lista", serv.listagem());
    mav.addObject("pagina", pagina);
    mav.addObject("items", items);
    mav.addObject("ordem", ordem);

    return mav;
}

@RequestMapping(value="listagem.json", method=RequestMethod.GET)
@PreAuthorize("hasPermission(#user, 'listagem_'+#this.this.name)")
public ModelAndView listagem_json(@RequestParam("pagina") String pagina, @RequestParam("items") String items, @RequestParam("ordem") String ordem) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName(this.getName()+"/listagem");

    mav.addObject("lista", serv.listagem());
    mav.addObject("pagina", pagina);
    mav.addObject("items", items);
    mav.addObject("ordem", ordem);

    return mav;
}