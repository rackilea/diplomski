@RunWith(PowerMockRunner.class)
@PrepareForTest(MyClass.class) //<-- you must prepare the class creating the new instance
public class MyClassTest {
    @Test
    public void test() {
        //Arrange
        int expected = 1;                          
        //Mock second class
        AnotherClass secondClass;
        secondClass = PowerMockito.mock(AnotherClass.class);
        PowerMockito.when(secondClass.anotherFunction(Mockito.any()).thenReturn(expected);

        //mocking initialization of second class withing first class
        PowerMockito.whenNew(AnotherClass.class).withNoArguments().thenReturn(secondClass);

        MyClass firstClass = new MyClass();

        //Act
        int actual = firstClass.myFunction();

        //Assert                
        assertEquals(expected, actual);
    }
}