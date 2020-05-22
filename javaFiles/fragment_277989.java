@GetMapping("/planetForm/{idPlanet}")
public String toPlanetForm(Model model, @PathVariable(value = "idPlanet", required = false) String idPlanet) {
    if (idPlanet != null){
        Planet planet = planetService.getById(Integer.parseInt(idPlanet));
        model.addAttribute("planet", planet);
    }
    List<Satellite> satellites = satelliteService.findAll();
    model.addAttribute("satellites", satellites);
    return "addPlanet";
}