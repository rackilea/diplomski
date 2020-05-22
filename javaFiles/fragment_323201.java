@InjectMocks
MyClass myClass;

@Mock
Service service;

@Captor
ArgumentCaptor argCaptor;

@Before
public void init(){
     MockitoAnnotations.initMocks(this);
}

@Test
public void shouldUseMyCallback(){
     // Arrange

     // set up myClass for test

     // Act
     myClass.userPressedButton();

    Mockito.verify(service).loadData(argCaptor.capture());

    // Assert
    assertTrue(argCaptor.getValue instance of MyCallback);
}