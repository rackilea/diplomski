@Spy
ClassUnderTest classUnderTest;

@Mock
Response responseMock;

@Before
public void init(){
    MockitoAnnotations.initMocks(this);
}

@Test
public void test(){
    doReturn(responseMock).when(classUnderTest).buildResponse();

    // Act

    classUnderTest.login(login,pass);

   // Assertions
}