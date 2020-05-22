public LogInController{
...

    @RequestMapping(value = "/logOut", method = RequestMethod.GET)
    public String logOut(ModelMap model) {

    //Redirect to your start page (mapping the url '/welcome' for example)
    return "redirect:welcome";
    }
...
}