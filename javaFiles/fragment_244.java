public void test() {
    // Arrange
    Outer outerSpy = spy(new Outer());
    doNothing().when(outerSpy).printHello(anyString()); // optional

    // Act
    outer.myMethod();

    // Assert
    verify(outerSpy).printHello("hello");
}