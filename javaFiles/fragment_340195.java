Thread ServerThread1 = new Thread(new Runnable() {

    @Override
    public void run() {
        ServerSocket ServerSocketObject = null;
        while(true)
        {
        try {
            ServerSocketObject  = new ServerSocket(Your_Port_Number1);

                Socket SocketObject = ServerSocketObject.accept();
                // Your Code Here
                SocketObject.close();

        } catch (IOException e) {
                try {
                    ServerSocketObject.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            e.printStackTrace();
        }
        }
    }
});

Thread ServerThread2 = new Thread(new Runnable() {

    @Override
    public void run() {
        ServerSocket ServerSocketObject = null;
        while(true)
        {
        try {
            ServerSocketObject  = new ServerSocket(Your_Port_Number2);

                Socket SocketObject = ServerSocketObject.accept();
                // Your Code Here
                SocketObject.close();

        } catch (IOException e) {
                try {
                    ServerSocketObject.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            e.printStackTrace();
        }
        }
    }
});

ServerThread1.start();
ServerThread2.start();