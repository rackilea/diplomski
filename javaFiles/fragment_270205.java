@RequestMapping(method=RequestMethod.GET, value={"/campaigns","/campaigns/{id}"})
@ResponseBody
public String getCampaignDetails(
     @PathVariable("id") Optional<String> id)
{ 
  if(id.isPresent()){
      model.addAttribute("id", id.get());//id.get() return your String path
  }
}