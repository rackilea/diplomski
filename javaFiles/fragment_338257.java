public class TestAClass 
{
    @Capturing InterfaceToMock anyImplementingInstance;

    @Test
    public void test1()
    {
        new ClassToTest().methodToTest();

        new Verifications() {{
            anyImplementingInstance.methodToMock();
        }};
    }
}