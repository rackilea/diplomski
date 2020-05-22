@RequestMapping(value = "/AddInventory.html", method = RequestMethod.POST)
public ModelAndView inventorymgmt(@ModelAttribute("itemTypeForm") @Valid Itemtype itemTypeForm, BindingResult result, Map<String, Object> model) throws Exception {
    logger.log(Level.OFF, "Add Inventory called with inventory details ####### ." + itemTypeForm);

    if (result.hasErrors()) {
        logger.log(Level.OFF, "Error occured while inserting the reconrd for the item type." + result.getAllErrors());
        ModelAndView modelAndView = new ModelAndView("add-item_category");
        modelAndView.addAllObjects(model);
        return modelAndView;
    }
    else {
        logger.log(Level.OFF, "Insert result ####### ." + itemTypeDAO.insert(itemTypeForm));
        return new ModelAndView("redirect://item_category.html");
    }
}