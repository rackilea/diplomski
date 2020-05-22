private Integer userid;

@NotEmpty(message = "Please enter your username.", groups={LoginGroup.class})
private String username;

@NotEmpty(message = "Please enter your password.", groups={LoginGroup.class})
private String userpw;

@NotEmpty(message = "Please enter your email.")
private String useremail;