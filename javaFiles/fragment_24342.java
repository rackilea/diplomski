@org.junit.Test
public void testMockPrivateMethod() throws Exception {
    MyClass myClass = PowerMockito.mock(MyClass.class);
    PowerMockito.when(myClass.B()).thenReturn("mockB");
    //PowerMockito.when(myClass, "B").thenReturn("mockB");
    System.out.println(myClass.B());
}

Output:
mockB