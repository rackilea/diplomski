@ModelAttribute
public void referenceData(@RequestParam(required=false) List<Integer> vacanciesSelected, Model model) {
    Set<Vacancy> vacancies= vacancyService.getAll();
    model.addAttribute("vacancies", vacancies);
    if (vacanciesSelected != null && !vacanciesSelected.isEmpty() ) {
        Set<Vacancy> vacanciesForCandidate = // Do something with the set
        model.addAttribute("vacanciesForCandidate", vacanciesForCandidate);
    }
}