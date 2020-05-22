@Rule
public ExpectedException exception = ExpectedException.none();
@Test
public void shouldNotPrintStackTrace() throws ArithmeticException {
    exception.expect(ArithmeticException.class);
    exception.expectMessage(containsString("by zero"));
    System.out.println(10 / 0);
}