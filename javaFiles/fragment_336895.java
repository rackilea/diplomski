@RunWith(PowerMockRunner.class)
@PrepareForTest(MyClass.class)  //tells powerMock we will modify MyClass to intercept calls to new somewhere inside it
public class MyClassTest{

    @Test
    public void test(){
          MyOtherClass myMock = createMock(MyOtherClass.class);
          //this will intercept calls to "new MyOtherClass()" in MyClass
          whenNew( MyOtherClass.class).withNoArguments().thenReturn( myMock) );
          ... rest of test goes here

   }