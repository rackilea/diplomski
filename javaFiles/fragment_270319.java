public class TestAClass 
{
    @Test
    public void test1()
    {
        final ClassToMock classToMockInstance = new ClassToMock();

        new Expectations(ClassToMock.class) {{
            classToMockInstance.methodToMock(); result = 1;
        }};

        new ClassToTest().methodToTest(); // prints "1"

        // This time the real method implementation will be executed:
        new ClassToTest().methodToTest(); // prints "2"
    }
}