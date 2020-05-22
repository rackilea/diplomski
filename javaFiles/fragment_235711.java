public void run () {
    byte[] buffer = new byte[1024];
    int len = -1;
    try (PrintWriter data = new PrintWriter("test.txt")) {
      while((len = this.in.read(buffer)) > -1) {
        String gpsInfo = new String(buffer,0,len);
        data.println(gpsInfo);
        System.out.print(gpsInfo);
      }
      data.flush();
    }
    catch ( IOException e ) {
      e.printStackTrace();
    }
  }