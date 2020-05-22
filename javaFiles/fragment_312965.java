@Test
public void testWhatever()
{
    try {
        codeThatRaisesSomeException();
        fail("No exception thrown!");
    catch (MyException e) {
        assertEquals(e.getMessage(), "the expected message here");
    }
}