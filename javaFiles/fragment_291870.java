@RequestMapping("/findAll")
@ResponseBody
public List<Journal> index() {
    List<Journal> all = journalService.findAll()
    return all;
}