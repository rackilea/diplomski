@RequestMapping(value = {"/init"}, method = RequestMethod.GET)
public String methodName(
@RequestParam Map<String,String> allParams, ModelMap model) {
 if (allParams.containsKey("with_empty_param ")) {
  ...
 }