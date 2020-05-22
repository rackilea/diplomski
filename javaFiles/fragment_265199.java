@Rule
public ExpectedException expectedEx = ExpectedException.none();

@Test
public void shouldThrowRuntimeExceptionWhenEmployeeIDisNull() throws Exception {
    expectedEx.expect(RuntimeException.class);
    expectedEx.expectMessage("Employee ID is null");

    // do something that should throw the exception...
    System.out.println("=======Starting Exception process=======");
    throw new NullPointerException("Employee ID is null");
}