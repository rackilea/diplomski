@JsonView(PersonResponseViews.Person.class)
    @RequestMapping("/person")
    public @ResponseBody
    PersonResponse getPerson() {
        PersonResponse resp = new PersonResponse();  
        resp.name = "first last";
        resp.profile = new PersonResponse.Profile();
        resp.profile.id = 1234;
        resp.error = new PersonResponse.Error();
        resp.error.code = 404;
        resp.error.message = "some random error";
        return resp;
    }

    @JsonView(PersonResponseViews.Profile.class)
    @RequestMapping("/profile")
    public @ResponseBody
    PersonResponse getProfile() {
        PersonResponse resp = new PersonResponse();
        resp.profile = new PersonResponse.Profile();
        resp.profile.id = 1234;
        resp.error = new PersonResponse.Error();
        resp.error.code = 404;
        resp.error.message = "some random error";
        return resp;
    }