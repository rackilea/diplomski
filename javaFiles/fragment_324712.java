@Mock
MyService myService

List<MyBusinessClass> myBusinessClasses = new ArrayList<>();
@Mock 
MyBusinessClass myBusinessClass1;
@Mock
MyBusinessClass myBusinessClass2;

@Before
public void setup()
{
myBusinessClasses.add(myBusinessClass1);
myBusinessClasses.add(myBusinessClass2);
when(myService.get()).thenReturn(myBusinessClasses);
}

@Test
public void callSomeMethodOnReturnedEntries(){
    new CodeUnderTest(myService).publicInterfaceMethod();

    verify(myBusinessClass1).expectedMethodCall();
    verify(myBusinessClass2).expectedMethodCall();
}