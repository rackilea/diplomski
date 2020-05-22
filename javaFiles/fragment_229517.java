private static class Meh
{
    public String meh() { return "meh"; }
}

@Test
public void testMeh()
{
    final Meh meh = spy(new Meh());

    doReturn("foo").doReturn("bar").doCallRealMethod().when(meh).meh();

    assertEquals("foo", meh.meh());
    assertEquals("bar", meh.meh());
    assertEquals("meh", meh.meh());
}