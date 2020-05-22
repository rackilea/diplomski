Socket sock = null;
    while (true) {
      try {
       sock = new Socket(from, 1234);
       if (sock != null) { break; }
       }
      catch (IOException e) { Thread.sleep(1000); }
    }
    // rest of the code