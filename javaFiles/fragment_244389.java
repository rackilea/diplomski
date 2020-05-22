public class SomeClass{
  @Inject
  private PersonHelper personHelper;
  ...
  public void someMethod(){
    ...
    List<Person> personsList = personHelper.getPersons();
    ..
  }
}