@RequestMapping(value = "firstCase", method = RequestMethod.POST)
    public String firstCase(@Validated(People.PeopleValidationGroup.class) People people, Errors errors) {
       ...
    }

 @RequestMapping(value = "secondCase", method = RequestMethod.PUT)
    public String secondCase(@Validated(People.AddressValidationGroup.class) People people, Errors errors) {
       ...
    }