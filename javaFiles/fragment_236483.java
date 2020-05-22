@Rule
public final ExpectedException expectedException = ExpectedException.none();

@Test
public void testExceptionCause() throws Exception {
    expectedException.expect(ExecutionException.class);
    expectedException.expectCause(isA(CustomException.class));

    throw new ExecutionException(new CustomException("My message!"));
}