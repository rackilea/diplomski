@RequestMapping(value = "/{varPost}", method = RequestMethod.GET)
public String getVarFromURI(@PathVariable("varPost") String theVar,
        Model model) {
    model.addAttribute("varFromClient", theVar);
    model.addAttribute("tokenFromClient", "[NOT SET]");
    return "someview";
}