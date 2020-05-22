ArrayList<Socket> clientSockets = new ArrayList<>();
    try {
            ServerSocket serverSocket = new ServerSocket(port); // port same as client
            InetAddress inetAddress = InetAddress.getLocalHost();
            System.out.println("Server opened at: "+inetAddress.getHostAddress());

            while (true) // this keeps the server listening
            {
                final Socket socket = serverSocket.accept(); // this accepts incomming connections
                clientSockets.add(socket); // adds current connection to an arraylist
                System.out.println(timestamp()+"Connection from "+socket.getInetAddress());
                    Thread t = new Thread(new Runnable() // Thread handles messages sent by client that just connected
                    {
                    @Override
                    public void run() {
                        try
                        {
                            while (socket.isConnected())
                            {
                                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                                String fromClient = br.readLine();
                                if (fromClient != null)
                                {
                                 //use message from client
                                }
                                else // connection might have been reset by client
                                    {
                                        socket.close();
                                        clientSockets.remove(socket);
                                    }
                            }
                        } catch (SocketException e)
                        {
                          System.out.println("Disconnection from "+socket.getInetAddress());
                        } catch (IOException e) {}
                    }
                });
                t.start();
            }
            } catch (Exception e) {}