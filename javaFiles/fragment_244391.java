public class PersonHelper{
    private FakeDatabaseConfiguration fakeDatabaseConfiguration;
    @Inject
    public PersonHelper(final FakeDatabaseConfiguration fakeDatabaseConfiguration){
        this.fakeDatabaseConfiguration = fakeDatabaseConfiguration;
    }

    public List<Person> getPersons(){
      FakeResult fakeResult = fakeDatabaseConfiguration.executeSQL("select * from Person");
      return fakeDatabaseConfiguration.asList();
    }

}