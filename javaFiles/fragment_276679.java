@RequestMapping(value = "/addNewGrade.html", method = RequestMethod.POST)
public String newGrade(@ModelAttribute("form") Grade grade) {

    gradeData.save(grade);
    return "redirect:/listModules.html";

}