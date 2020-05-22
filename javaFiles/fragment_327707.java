private static void startH2(){
    Server tcpServer = null;
    Server webServer = null;
    try {
        tcpServer = Server.createTcpServer("-tcpAllowOthers").start();
        System.out.println("TCP Server Port: " + tcpServer.getPort());
        Class.forName("org.h2.Driver");
        Connection conn = DriverManager.
                getConnection("jdbc:h2:tcp://localhost/~/test22;MODE=PostgreSQL", "sa", "");
        webServer = Server.createWebServer().start();
        System.out.println("Web Server (H2Console) Port: " + webServer.getPort());
    } catch (Exception e) {
        e.printStackTrace();
    }
    System.out.println("finish");
}