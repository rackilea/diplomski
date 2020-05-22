private Integer userid;

@NotEmpty(message = "Please enter your username.", groups={LoginGroup.class, RegistrationGroup.class})
private String username;

@NotEmpty(message = "Please enter your password.", groups={LoginGroup.class, RegistrationGroup.class})
private String userpw;

@NotEmpty(message = "Please enter your email.", groups={RegistrationGroup.class})
private String useremail;