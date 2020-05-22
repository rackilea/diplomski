@RequestMapping(value="/signup",method=RequestMethod.POST)
          @ResponseBody
            public ProfileDTO signup(@ModelAttribute("LoginDTO") LoginDTO loginDTO,BindingResult bindingResult) {
              ProfileDTO profileDto = new ProfileDTO();
    //In case no errors in backend logic
              profileDto.setError(null);
              profileDto.setProfileID("profileID");
              profileDto.setProfileName("profileName");
              System.out.println("Submitting SignUP Form Will Return ProfileID");

             return profileDto;


            }