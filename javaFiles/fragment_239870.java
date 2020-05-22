@PutMapping("/createUser")
public ModelAndView createUser(@RequestBody User user) {
    ModelAndView mv= new ModelAndView("reached-here");
    User thisValue = repository.findByUsername(user.getUsername());
    if (thisValue != null) {
        model.setStatus(HttpStatus.BAD_REQUEST);
        model.setValueName("account-exist");
    }else{
        model.setStatus(HttpStatus.OK);
    }
    return mv;
}