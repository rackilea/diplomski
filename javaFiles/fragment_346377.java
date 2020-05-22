public class MyTestClass{

   private PersonServiceImpl personService;
   private PersonDAO dao;
   private Person person;
   private ArgumentCaptor<Person> argCaptor;

   @Before
   public void setup(){
       person = new Person();

       argCaptor = ArgumentCaptor.forClass(Person.class);

       // set up mock to return person object
       dao = Mockito.mock(PersonDAO.class);
       when(dao.getPerson(5).thenReturn(person);

       // create class under test with mock
       personService = new PersonServiceImpl(dao);
   }

   @Test
   public void myTest(){
      // test
      psersonService.changeName(....);

      // verify
      verify(dao).update(argCaptor.capture());
      Person passedPerson = argCaptor.getValue();
      assertThat(passedPerson.getFirstName(), equalTo(...));
   }
}