@RequestMapping(value = "/group-editing", method = RequestMethod.GET)
    public String groupEditingShow(@RequestParam(value = "id") Long id,
            Model model) {
        Group group = groupService.findOne(id);
        model.addAttribute("group", group);
        return "group-editing";
    }

    @RequestMapping(value = "/group-editing", method = RequestMethod.POST)
    public String editGroup(@ModelAttribute("group") Group group,
            @RequestParam("id") Long id) {
        group.setId(id);
        groupService.update(group);
        return "redirect:/group?id={id}";
    }