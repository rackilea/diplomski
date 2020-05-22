while(true) {                
      Socket sock = servsock.accept();                
      System.out.println("Connection from: " + sock.getInetAddress());                
      Scanner in = new Scanner(sock.getInputStream());                
      PrintWriter out = new PrintWriter(sock.getOutputStream());                
      String request = "";                
      while (in.hasNext()) {
          request = in.next();                
          System.out.println("Request: " + request);                
          if(request.toUpperCase().equals("TIME")) {                     
              out.println(getTime());
              out.flush();                
          } else {
               out.println("Invalid Request...");                     
               out.flush();
          }
      }
 }