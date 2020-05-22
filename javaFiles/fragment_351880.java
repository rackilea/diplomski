@RequestMapping(value = "/save", method = RequestMethod.POST)
public ModelAndView saveGroup(@Valid Group group, BindingResult result) {
    if (result.hasErrors()) {
        return new ModelAndView("/teacher/groups/edit", "specialties", specialtyService.list());
    }
    groupService.update(group);
    return new ModelAndView("redirect:/teacher/groups");
}