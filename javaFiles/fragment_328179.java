@JsonView(User.Views.Public.class)
    public String getFirstname() {
        return firstname;
    }

 @JsonView(User.Views.Public.class)
    public String getLastname() {
        return lastname;
    }