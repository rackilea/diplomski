@RequestMapping(method = RequestMethod.GET)
    public String printUser(User user,ModelMap model){
        user.setName("Pavel");
        user.setSname("Petrashov");
        user.setSname("Petrashov");
        user.setAge(24);

        model.addAttribute("user",user);
        return "user"; 
    }