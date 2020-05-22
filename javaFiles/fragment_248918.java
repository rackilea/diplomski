public static void main(String... args) {

    Server s = Server.getServerInstance();
    s.init();
    s.start();
    try {
        Thread.sleep(5000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    s.stop();
}