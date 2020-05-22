public ModelAndView redirectWithResponse(@RequestParam("redirect_url")
  String redirectUrl, @RequestParam("data") String data,
  RedirectAttributes redir) {
    ...

    MyJSONResponse response = new MyJSONResponse(data);

    ModelAndView modelAndView = 
            new ModelAndView("redirect:" + redirectUrl);
    redir.addFlashAttribute("object", response);
    return modelAndView;
    ...
}