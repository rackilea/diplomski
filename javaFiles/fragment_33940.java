ServerSocket serverSocket = null;
    Socket clientSocket =null;
    Scanner in = null;
    try 
    {
        serverSocket = new ServerSocket(4444);
        System.out.println("Server Started...");
        clientSocket = serverSocket.accept();

        in = new Scanner(clientSocket.getInputStream());
        String inputLine;

        while (true)  {
            if(in.hasNext()) {
                inputLine=in.nextLine();
                    System.out.println("Message from server: "+inputLine);
            }
        }
    } catch(IOException e) {
        e.printStackTrace();
    } finally {
        if(in != null) {
            in.close();
        }
        if(clientSocket != null) {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(serverSocket != null) {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }