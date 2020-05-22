@RequestMapping(value = "/calcdireto.json", method = RequestMethod.POST)
public @ResponseBody CalcDiretoResponse processFormAjaxJson(Model model,
    @ModelAttribute(value = "formBean") @Valid CalcDiretoFormBean cdBean,
    BindingResult result) {
CalcDiretoResponse res = new CalcDiretoResponse();
if (!result.hasErrors()) {
      res.setValStatus("SUCCESS");
      final WebContext ctx = new WebContext(request,servletContext,request.getLocale());
      res.setHtml(this.templateEngine.process("subpage", ctx));     
      return res;
}   ...