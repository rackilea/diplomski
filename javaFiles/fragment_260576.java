@Test
public void test() {
    MyInterface myInterface = mock(MyInterface.class);
    FooBar expectedFooBar = new FooBar();        

    // other testing stuff

    verify(myInterface).myMethod(any(), any(), eq(expectedFooBar), any(), ...);
}