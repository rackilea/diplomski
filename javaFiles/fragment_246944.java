/**
 * Custom handler for displaying an owner.
 *
 * @param ownerId the ID of the owner to display
 * @return a ModelMap with the model attributes for the view
 */
@RequestMapping("/owners/{ownerId}")
public ModelAndView showOwner(@PathVariable("ownerId") int ownerId) {
    ModelAndView mav = new ModelAndView("owners/ownerDetails");
    Owner owner = this.clinicService.findOwnerById(ownerId);
    owner.parsePets();
    mav.addObject(owner);
    return mav;
}