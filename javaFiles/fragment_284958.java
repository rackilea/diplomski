@RequestMapping()
protected String initPage(Model model) {

    List<StateDropDownEntry> states = stateService.getStates();
    List<TownDropDownEntry> towns = townService.getTowns();

    ObjectMapper objMapper = new ObjectMapper();
    String statesJson = objMapper.writeValueAsString(states); // try|catch removed for clarity
    String townsJson = objMapper.writeValueAsString(towns);  

    model.addAttribute("statesJson",statesJson);
    model.addAttribute("townsJson",townsJson);

    return "stateTownQueryPage";
}