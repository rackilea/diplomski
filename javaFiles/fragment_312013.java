@ModelAttribute("encountercodes") 
public Map populateEncountercodes() { 
   Map<Integer, String> encCodes = new LinkedHashMap<Integer, String>(); 
   for(CPTCode cpt: this.clinicService.findEncountercodes()){ 
     encCodes.put(cpt.getId(), cpt.getName()); 
   } 
   return encCodes; 
}