@Test
  public void test(
      @Mocked final System systemMock,
      @Mocked final Console consoleMock) {
    new NonStrictExpectations() {
      {
        System.console();
        result = consoleMock;

        consoleMock.readLine(anyString);
        result = "aUsername";

        consoleMock.readPassword(anyString);
        result = "aPassword";
      }
    };

    MyClass.main(null);
  }