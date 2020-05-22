//use a SocketAddress so you can set connect timeouts
        InetSocketAddress sockAddress = new InetSocketAddress("127.0.0.1",40000);
        s  = new Socket();
        //set connect timeout to one minute
        s.connect(sockAddress, 60000);
        //set read timeout to one minute
        s.setSoTimeout(60000);            
        System.out.println(s);
        pw = new PrintWriter(s.getOutputStream());
        ...