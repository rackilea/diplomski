@ModelAttribute("formBean")
public FormBean getFormBean() {
    return new FormBean(getVerteilungenMatrix());
}

@RequestMapping(value = "/verteilung", method = RequestMethod.GET)
public String showPage() {
    return "konfiguration/verteilung";
}

private List<List<Boolean>> getVerteilungenMatrix() {
     List<List<Boolean>> result2 = new ArrayList<>();
        for (int i = 0; i < kategorien.size(); i++) {
            result2.add(new ArrayList<>());
        }
        //...
        return result2;
}