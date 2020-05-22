class A {
    protected static MyObject a;
    public static void someMethod() {
        a = new MyObject("cccc");
    }
}

public class B  extends A {
    @BeforeClass
    public static void setUpBeforeClass() {
        someMethod();
    }
    @Test
    public void mockTest() {
        MyObject mock_object = Mockito.spy(a);
        Mockito.doReturn(false).when(mock_object).xyz();
        assertThat(mock_object.xyz()).isFalse();
    }

@Test
public void mockTest2() {
    MyObject mock_object = Mockito.spy(a);
    // Here we replace original object with our spy
    A.a = mock_object;
    Mockito.doReturn(false).when(mock_object).xyz();
    assertThat(a.xyz()).isFalse();
}
}