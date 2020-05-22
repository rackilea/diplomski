Assuming the form backing object "formObject" has been passed as a parameter to the controller handler method (via the ModelAttribute annotation) and has properties "param1" and "param2" that are Strings -

modelMap.clear();
modelMap.addAttribute("param1", formObject.getParam1());
modelMap.addAttribute("param2", formObject.getParam2());
return "redirect:/my/url";