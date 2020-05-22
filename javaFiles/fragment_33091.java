do {
     socket = new Socket("127.0.0.1", 12345);
     in = new DataInputStream(socket.getInputStream());
     out = new DataOutputStream(socket.getOutputStream());

        System.out.print("Guess a number: ");
      ........