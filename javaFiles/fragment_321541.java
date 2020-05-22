public static class TcpServerStarter extends Thread {

    @Override
    public void run() {
        new TcpServer(8500).run();
    }
}

public static class UdpServerStarter extends Thread {

    @Override
    public void run() {
        new UdpServer(1000).run();
    }
}