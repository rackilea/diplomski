@RunWith(PowerMockRunner.class)
@PrepareForTest(MyClass.class)
class MyClassTest
{
    @Test
    public void test()
    {
       PowerMockito.spy(MyClass.class);
       doNothing().when(MyClass.class, "methodB", anyString());
       MyClass.methodA("s");
    }
}