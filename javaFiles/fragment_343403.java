@Entity 
public class Account
{
  @Id
  private int id;
  private String name;
  private String password; //no bad don't do this really
}

@Entity
public class Person {
  @Id
  private int id;
  private String name;
  private int age;
  private Account account; //custom type
  private Calendar anniversary;
  ...
}