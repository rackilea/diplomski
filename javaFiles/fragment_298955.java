@RequestMapping(value = "/redirect")
public RedirectView redirect(){

return new RedirectView("check");

}