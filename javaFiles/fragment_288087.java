client = server.accept();      
    clientsocket = new Socket(InetAddress.getLocalHost(), 6780);
    Thread t1 = new ProxyHandler(client, clientsocket );
    t1.start();
    Thread t2 = new ProxyHandler(clientsocket, client);
    t2.start();