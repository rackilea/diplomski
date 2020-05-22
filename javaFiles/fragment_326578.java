public class ErrorDto {
  private String message;

  public ErrorDto(String msg) { this.message = msg; }

  public String getMessage() { return this.message; }
}