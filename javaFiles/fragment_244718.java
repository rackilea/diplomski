public class Person {
  private int id;
  private String name, email;
  @JsonFormat
  (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private Date birthDate;

  //add here getters and setters ...
}