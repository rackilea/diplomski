@RequestMapping({"", "/"})
public String index(Model model) {
    model.addAttribute("printerEntity", new PrinterEntity());
    return "index";
}

@RequestMapping(value = "/print", method = RequestMethod.POST)
public String printPost(@Valid PrinterEntity printerEntity, BindingResult bindingResult, Model model) {
    model.addAttribute("printed", printerEntity.getName());
    model.addAttribute("printerEntity", printerEntity);

    if (bindingResult.hasErrors()) {
        return "index";
    }

    return "printer/secretarea";
}