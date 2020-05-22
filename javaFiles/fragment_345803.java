public class Form {

  public interface Group1 { /*empty interface*/ };

  public interface Group2 { /*empty interface*/ };

  @NotEmpty(groups = { Group1.class }) // associate constraints
  private String field1;               // to a validation group 

  @NotEmpty(groups = { Group2.class })
  private String field2;

}