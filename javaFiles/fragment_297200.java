@Test
public void testRewind() throws Exception 
{
    BufferedReader rdr = new BufferedReader(new StringReader("foo\nbar\nbaz\n"));
    ReaderBuffer buf = new ReaderBuffer(rdr);

    assertEquals("foo", buf.readLine());
    assertEquals("bar", buf.readLine());
    assertEquals("baz", buf.readLine());
    assertEquals(null,  buf.readLine());

    buf.rewind(2);

    assertEquals("bar", buf.readLine());
    assertEquals("baz", buf.readLine());
    assertEquals(null,  buf.readLine());
}