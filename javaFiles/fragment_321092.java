// Get All Units
  @RequestMapping(value="/getAllUnits/", method=RequestMethod.GET)
  public @ResponseBody List<UnitDTO> getAllUnits()
  {
    return unitService.getAllUnits();
  }