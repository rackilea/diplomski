@PrepareForTest(ArrTest.class)
@RunWith(PowerMockRunner.class)
public class ArrTestTest {
    @Test
    public void myMethodTest(){
        PowerMockito.stub(PowerMockito.method(ArrTest.class, "myMethod")).toReturn(0);
        System.out.println(ArrTest.myMethod(null));
    }
}