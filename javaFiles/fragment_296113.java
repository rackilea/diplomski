public class MessageTest {
    @Test
    public void testSimplePayload() () {
        byte[] emptyPayload = new byte[1001];

        // Using Mockito
        final Socket socket = mock(Socket.class);
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        when(socket.getOutputStream()).thenReturn(byteArrayOutputStream);

        Message text = new Message(emptyPayload) {
            @Override
            protected Socket createSocket() {
                return socket;
            }
        };

        Assert.assertTrue("Message sent successfully", text.sendTo("localhost", "1234"));
        Assert.assertEquals("whatever you wanted to send".getBytes(), byteArrayOutputStream.toByteArray());
    }
}