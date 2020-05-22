public class MyPojo {

  @DateTimeFormat(iso = ISO.DATE)
  private LocalDate localDate1;

  // you can use pattern as well
  @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm")
  private LocalDate localDate2;

  // setters & getters
}