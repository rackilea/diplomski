@RequestMapping(value="/owners/{ownerId}", method=RequestMethod.GET)
 public String findOwner(@PathVariable String ownerId, Model model) {
     Owner owner = ownerService.findOwner(ownerId);
     model.addAttribute("owner", owner);
     return "displayOwner"; 
  }