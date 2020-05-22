public MyObjectReaderTest
{
  @Test
  public void testRead() throws IOException
  {
    String input = "value1.1,value1.2,value1.3\n" +
      "value2.1,value2.2,value2.3\n" +
      "value3.1,value3.2,value3.3";

    try (MyObjectReader reader = new MyObjectReader(new StringReader(input)))
    {
      assertEquals(new MyObject("value1.1", "value1.2", "value1.3"), reader.read());
      assertEquals(new MyObject("value2.1", "value2.2", "value2.3"), reader.read());
      assertEquals(new MyObject("value3.1", "value3.2", "value3.3"), reader.read());
      assertNull(reader.read());
    }
  }

  @Test(expected=IOException.class)
  public void testReadWithInvalidLine() throws IOException
  {
    String input = "value1.1,value1.2";

    try (MyObjectReader reader = new MyObjectReader(new StringReader(input)))
    {
      reader.read();
    }
  }
}