@Test
public void testHandler(){
  Socket s = mock(Socket.class);
  InputStream is = new ByteArrayInputStream(new String("Hello").getBytes());

  try {
    when(s.getInputStream()).thenReturn(is);
  } catch (IOException e) {
    e.printStackTrace();
  }

  Handler h = Manager.new Handler(s);

  assertNotNull(h.in);
}