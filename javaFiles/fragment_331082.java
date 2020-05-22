@RequestMapping(value="/{username}")
    public String getUserName(Model model,@PathVariable("username") String username){

        //process username here and then redirect to ur profile method

        return "redirect : profile?username="+username;
    }

    @RequestMapping(value="/profile")
    public String profiles(Model model,String username){

        //have a username and render a profile page 

        return "profile";
    }