finally {
 try {
    if (writer != null) {
      writer.close();
    }
 } catch (IOException ioexception) {
    //log exception
 }