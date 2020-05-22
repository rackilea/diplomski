/* We can place this code in the JUnit test Class */
@Mock
PersonDAO personDAO;

@InjectMocks
PersonService personService;

@Before
public void setUP() {
    MockitoAnnotations.init(this);
}

@Test
public void shouldUpdatePersonName(){ 
    ReflectionTestutils.setField(personService,"personDao",personDAO);
    ............Remaining Code..........
}