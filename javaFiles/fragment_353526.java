@Captor
 ArgumentCaptor<GenericClass<SomeDifferentClass>> captor;

 @Before
 public void setup(){ MockitoAnnotations.initMocks(this));}

 @Test
 public void test(){
   when(mockA.methodThatNeedsToBeStubbed(captor.capture()))...
 }