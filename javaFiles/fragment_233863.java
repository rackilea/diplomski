new Thread(
    new Runnable() {
      public void run() {
        try {
          byte[] buffer = new byte[1024];

          int bytesRead;
          while ((bytesRead = System.in.read(buffer)) != -1) {
            process.getOutputStream().write(buffer, 0, bytesRead);
          }
        } catch (IOException e) {
          // Do something with the error...
        }
      }
    }
  ).start();