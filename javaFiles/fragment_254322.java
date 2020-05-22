public class Child {

  @DateTimeFormat(pattern="dd/MM/yyyy")
  private Date birthday;

  @DateTimeFormat(iso=ISO.DATE)
  private Date graduationDay;

  @NumberFormat(style = Style.CURRENCY)
  private Integer myNumber1;

  @NumberFormat(pattern = "###,###")
  private Double myNumber2;

}