@GetMapping("/update/{id}")
public String getForUpdate(@PathVariable String id, Model model) {
    John john = dataManager. load(id);
    model.addAttribute("john", john);
    return "update";
}