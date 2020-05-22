@RequestMapping("/findAll")
@ResponseBody
public Model index(Model model) {
    List<Journal> all =journalService.findAll();
    model.addAttribute("journalList", all);
    return model;
}