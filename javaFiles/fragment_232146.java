@Test
public void testMyTestClass() throws Exception {
    //Arrange
    MyClass myClass = mock(MyClass.class);
    doNothing().when(myClass).setFileName(anyString());
    doReturn(11).when(myClass).getOutputTableArgsSize();

    MyClassFactory factory = mock(MyClassFactory.class);
    doReturn(myClass).when(factory).Create(anyString());

    TestClass subject = new TestClass(factory);

    //Act
    List<String> result = subject.test("ab", "cd", "ef", "gh");

    //Assert
    assertEquals(result.size(), 1);
}