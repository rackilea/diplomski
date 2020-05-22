@RequestMapping(value = "/loadPOAction", method = RequestMethod.POST)
public @ResponseBody String loadOrder(HttpServletRequest request, Model model, @RequestBody final  OrderSearch search) {

  model.addAttribute("search", search);
  model.addAttribute("name", "to be added to model");

  return "theNameOfYourJspView";
}