Socket socket = new Socket();
        int linger = -2;//To distinguish the "initial value"
        try {
            linger = socket.getSoLinger();
        } catch (SocketException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Socket.getLinger() = "+linger);