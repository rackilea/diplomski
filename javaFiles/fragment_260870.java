@Test
public void testShouldOpenPortOnOpenConnection()
      throws Exception {

    SerialPort mockedPort = mock(SerialPort.class);
    PortHandler portHandler = new PortHandler(mockedPort);
    portHandler.openConnection();

    verify(mockedPort, times(1)).openPort();
}