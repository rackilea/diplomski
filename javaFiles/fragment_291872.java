@RequestMapping("/findAll")
public String index(Model model) {
    List<Journal> all;
    all = journalService.findAll();
    model.addAttribute("journalList", all);
    return "listall";
}