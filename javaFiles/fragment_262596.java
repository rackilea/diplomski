@RunWith(PowerMockRunner.class)
@PrepareForTest(ClassOfInterest.class)
public class ClassOfInterestTest {

  @Test
  public void someTestMethod() {

  //Line changed:
  ClassOfInterest coiMock = PowerMockito.mock(new ClassOfInterest());

  //Line changed:
  PowerMockito.doReturn(null).when(coiMock, "methodIWantToMock", any(String.class));

  //Line added:
  PowerMockito.when(coiMock.methodUsingThePrivateMethod()).thenCallRealMethod();

  coiSpy.methodUsingThePrivateMethod();

  //Do some stuff ...

  }
}