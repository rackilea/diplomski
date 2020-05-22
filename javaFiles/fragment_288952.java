@PrepareForTest(ArrTest.class)
public class ArrTestTest {

    @Rule
    public PowerMockRule rule = new PowerMockRule();

    @Test
    public void myMethodTest(){
        PowerMockito.stub(PowerMockito.method(ArrTest.class, "myMethod")).toReturn(0);
        System.out.println(ArrTest.myMethod(null));
    }
}