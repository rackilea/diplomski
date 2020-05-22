private final static Object lock = new Object();

public static void main (String[] args) throws Exception{
    Runnable send = new SendThread();
    Runnable recv = new ReceiveThread();
    new Thread(send).start();
    new Thread(recv).start();
}