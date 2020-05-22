@Rule
public final ExpectedException exception = ExpectedException.none();

@Test
public void testExceptionOccurs() throws Exception {
    exception.expect(CustomMalformedDataException.class);
    //code that casues exception to happen
}