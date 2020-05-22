if(button.getText() == "Avvia"){

    System.out.print("Server avviato");
    Thread server = new Server(); 
    System.out.print("Server avviato");
    server.start(); // <- not run()
    System.out.print("Server avviato");
  }