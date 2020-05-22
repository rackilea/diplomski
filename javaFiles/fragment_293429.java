@GetMapping("/tablePage")
public void getTableData(Model model) {

    inputRepository.findAll().forEach(inputObject -> {
        inputMap.put(inputObject.id, inputObject);
    });

    if (inputMap != null){
        inputMap.forEach((id, i) -> {
            model.addAttribute(id + "name", id + i.getName());
            model.addAttribute(id + "description", id + i.getDescription());
        });
    }

    model.addAttribute("InputMap", inputMap);
}