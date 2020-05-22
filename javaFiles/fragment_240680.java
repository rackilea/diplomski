new Thread() {
    public void run() {
      try {
        while (true) {
          String message = br.readLine();
          System.out.println("Message received from the server : " +message);
        }
      } catch(IOException e) {
        e.printStackTrace();
      }
    }
  }.start();