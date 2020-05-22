@Mock
private javax.inject.Provider<MyPrototype> prototypeFactoryStub;

@Mock 
MyPrototype prototypeMock;

@InjectMocks 
MySingleton sut;

@Before
public void init(){
   MockitoAnnotations.initMocks(this); // optional

   when(prototypeFactoryStub.get()).thenReturn(prototypeMock);
}

@Test
public void testPrototype() {
    sut.doStuff();
    verify(prototypeMock, times(1)).invoke();
}