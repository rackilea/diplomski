@PostMapping("/postEditMenu")
public String postEdit(@ModelAttribute("newMenu")Menu menu){


menuRepository.save(menu);

return "redirect:/recipeList";
}