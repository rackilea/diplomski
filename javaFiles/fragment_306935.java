public class PasswordUpdateRq {
  @Size(min = 8, max = 72, message = "Your password must be between 8 and 72 characters long")
  @NotEmpty(message = "Please provide a password")
  private String password;
  private String token;

  // Getters and setters omitted 
}