public class LoginBean {

  @NotBlank(message = "User Name field can not be blank")
  @Size(max = 10, message = "User Name should not be more than 10 characters")
  private String userName;
....