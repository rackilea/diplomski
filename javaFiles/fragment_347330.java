public ModelMap getUserDetails() {
    UserDetails userDetails; // get this object from somewhere
    ModelMap map = new ModelMap()(;
    map.addAttribute("data", userDetails);
    map.addAttribute("success", true);
    return map;
}