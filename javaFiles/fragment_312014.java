@RequestMapping(value = "/patients/{patientId}/encounters/{encounterId}/codes", method = {RequestMethod.POST}) 
    public String processUpdateCodesForm(@ModelAttribute("encounter") Encounter encounter,            
@PathVariable("encounterId") int eid, BindingResult result, SessionStatus status) { 
       Encounter myencounter = this.clinicService.findEncounterById(eid); 
       CPTCode myCode = this.clinicService.findCPTCodeById(encounter.getCodeSelected()); 
       myencounter.addCode(myCode); 
       return "redirect:/encounters?encounterID={encounterId}"; 
    }