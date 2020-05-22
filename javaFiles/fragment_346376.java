public class MyTestClass{
   Mockery context = new Mockery();

   private PersonServiceImpl personService;
   private PersonDAO dao;
   private Person person;

   @Before
   public void setup(){
       person = new Person();

       // set up mock to return person object
       dao = context.mock(PersonDAO.class);
       oneOf (dao).getPerson(5); will(returnValue(person));

       // create class under test with mock
       personService = new PersonServiceImpl(dao);
   }

   @Test
   public void myTest(){

    // expectations
    context.checking(new Expectations() {{
        oneOf (dao).update(person);
    }});

      // test
      psersonService.changeName(....);

    // verify
    context.assertIsSatisfied();
   }
}