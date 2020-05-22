@RunWith(PowerMockRunner.class)
@PrepareForTest(MyTestedClass.class)
public class TestClass {

    @Test
    @SuppressWarnings("unchecked")
    public void myMethodTest() throws Exception {

        MyClass<String> myMock = (MyClass<String>) EasyMock.createMock(MyClass.class);
        myMock.callToMock();

        PowerMock.expectNew(MyClass.class, "my argument")
                .andReturn(myMock);

        EasyMock.replay(myMock);
        PowerMock.replayAll();

        MyTestedClass tested = new MyTestedClass();
        tested.myMethod("my argument");
    }
}