public class Person {
  @Id
  @Column(name = "PERSON_ID")
  private Long personId;

  @Transient
  private transient Boolean superAdmin = false;

  // This method will be called automatically when object is loaded
  @PostLoad
  void onPostLoad() { 
    // BTW, personId has to be present in the table since it is id column. Do you want to check if it is 1?
    superAdmin  =  personId == 1;  
  }
}