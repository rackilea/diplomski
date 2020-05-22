public final class MessageTest extends JMockitTest
{
   static final String testContents = "hello there";
   static final String[] expectedEvents = {"DISPATCHED", "DISPLAYED", "READ"};

   @Test
   public void testSendMessageToSingleClient()
   {
      final Client theClient = new Client("client1");
      Client[] testClient = {theClient};

      new MockUp<Socket>()
      {
         @Mock(invocations = 1)
         void $init(String host, int port)
         {
            assertEquals(theClient.getAddress(), host);
            assertTrue(port > 0);
         }

         @Mock(invocations = 1)
         public OutputStream getOutputStream() { return new ByteArrayOutputStream(); }

         @Mock(invocations = 1)
         public InputStream getInputStream()
         {
            return new ByteArrayInputStream("reply1\nreply2\n".getBytes());
         }

         @Mock(minInvocations = 1) void close() {}
      };

      StatusListener listener = new MockUp<StatusListener>()
      {
         int eventIndex;

         @Mock(invocations = 3)
         boolean updateStatus(Status status)
         {
            assertSame(theClient, status.getClient());
            assertEquals(expectedEvents[eventIndex++], status.getEvent());
            return eventIndex < expectedEvents.length;
         }
      }.getMockInstance();

      new Message(testClient, testContents, listener).dispatch();
   }
}