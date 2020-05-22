StreamConnection c = null;
InputStream is = null;
try {
  StringBuffer sb = new StringBuffer();
  c = (StreamConnection) Connector.open(
       "http://www.cnn.com.br/", Connector.READ_WRITE);
  is = c.openInputStream();
  InputStreamReader r = new InputStreamReader(is, "UTF-8");
  System.out.println(r.read());
} catch (IOException ex) {
  ex.printStackTrace();
} finally {
  if (is != null) {
    try {
      is.close();
    } catch (Exception ex) {
      System.out.println("Failed to close is!"); 
    }
  }
  if (c != null) {
    try { 
      c.close(); 
    } catch (Exception ex) {
      System.out.println("Failed to close conn!"); 
    }
  }
}