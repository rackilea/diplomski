@RequestMapping(value = "/form", method = RequestMethod.GET)
    public String index(Info info, Model model) {
        model.addAttribute("info", info);
        return "myform";
    }

@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("info") Info info, HttpServletRequest request, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "myform";
        }