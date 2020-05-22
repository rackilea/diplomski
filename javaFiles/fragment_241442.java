@ModelAttribute("obj")
 public List<Address> getAllAddresses() {
  // Delegate to service
  return new CustomObject();
 }

@RequestMapping(value="list1", method = RequestMethod.GET)
    public String getAllUsingModelAttribute(CustomObject customObject) {