public class Person {
  @Id
  @Column(name = "PERSON_ID")
  private Long personId;

  boolean isSuperAdmin() { 
      return  personId == 1;
  }
}