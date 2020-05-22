fromRedirectMethod(..., RedirectAttributes redirectAttrs){
     redirectAttrs.addFlashAttribute("myAttr1","myAttrVal1").addFlashAttribute("myAttr2", "myAttrVal2");
...perform redirect
}

inRedirectedMethod(@ModelAttribute("myAttr1") myAttr1.., Model model){
    model.asMap().get("myAttr2");.
}