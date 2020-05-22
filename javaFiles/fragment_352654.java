@RequestMapping("/sighting")
public String makeSighting(Model model, Principal principal) {

    List<Pest> pests = pestsService.getPests();
    SightingForm sightingForm = new SightingForm();
    sightingForm.setSighting(new Sighting());
    sightingForm.setPests(pests);

    model.addAttribute("sightingForm", sightingForm);

    return "sighting";
}