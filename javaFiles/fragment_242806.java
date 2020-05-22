class NetworkInputStream extends InputStream {
  private int m_Offset = 0;  
  private ByteArrayOutputStream m_Buffer = null;

  Ipports m_Ipports = null;
  public NetworkInputStream(Ipports ipport) {
    m_Ipports = ipport;
    m_Buffer = new ByteArrayOutputStream();
    try { m_Ipports.receiveStream(m_Buffer); } catch (Exception e) {}
    m_Offset = 0;
  }
  public void waitForData() throws Exception {  
    if (dataAvailable() == 0) { 
      m_Buffer.reset();
      m_Offset = 0;
    }
    while (dataAvailable() == 0 && m_Ipports.isConnected()) {      
      m_Ipports.doEvents();
    }
  }
  private int dataAvailable() {
    return m_Buffer.size() - m_Offset;  
  }
  public int read(byte[] buffer, int offset, int length) throws IOException, IndexOutOfBoundsException {
    try {
      waitForData();
    } catch (Exception e) { 
      throw new IOException(e.getMessage()); }
    int bytesRead = -1;
    int dataAvailable = dataAvailable();
    if (dataAvailable > 0) {
      bytesRead = Math.min(dataAvailable, length);
      m_Buffer.toByteArray();
      System.arraycopy(m_Buffer.toByteArray(), m_Offset, buffer, offset, length);      
      m_Offset += bytesRead;
    }
    return bytesRead;
  }
  @Override
  public int read() throws IOException {
    byte[] buf  = new byte[] { 0x00 };
    int rval = read(buf, 0, 1);
    if (rval == -1) return rval;
    int cast = (int)buf[0] & 0xff;
    return cast;
  }
}