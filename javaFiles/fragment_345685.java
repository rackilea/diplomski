@PreAuthorize("isAuthenticated()")
@RequestMapping(value = "/new", method = RequestMethod.GET)
public String newProject (Model model) throws Exception {
    model.addAttribute(new Project());
    return "project/new";
}