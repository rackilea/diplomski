@RequestMapping(value = "delete.html", method = RequestMethod.POST)
    public String deleteUser(@RequestParam("id") int id, Model model) {
    service.delete(id);
    model.addAttribute("usersId", service.findAllIdForUsers());
        return "example";
    }