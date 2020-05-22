@PostMapping("/country/{id}/agents/new")
public String createAgent(@PathVariable(value = "id") String countryId, @ModelAttribute Agent agent){
    return countriesRepository.findById(Long.parseLong(countryId)).map(country -> {
        Agent agentToBeSaved = new Agent();
        agentToBeSaved.setCountry(country);
        agentToBeSaved.setStatus(agent.getStatus());
        agentToBeSaved.setFirstName(agent.getFirstName());
        agentToBeSaved.setDocuments(agent.getDocuments());
        agentToBeSaved.setPeopleRecruited(agent.getPeopleRecruited());
        agentsRepository.save(agentToBeSaved);
        return "redirect:/country/" + countryId + "/show/agents";
    }).orElseThrow(() -> new ResourceNotFoundException("CountryId " + countryId + " not found"));
}