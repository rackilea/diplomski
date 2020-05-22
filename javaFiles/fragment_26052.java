@Test
public void testConnectAfterClose() {
    Channel helper = new EmbeddedChannel(mock(ChannelHandler.class));
    chMock = spy(helper);

    when(chMock.close()).thenReturn(promise);
    node.connect(address);
    node.close();
    promise.setSuccess();
    node.connect(address);
}