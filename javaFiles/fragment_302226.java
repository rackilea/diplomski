public class LoginServer {
    private static final Logger log = LoggerFactory.getLogger(LoginServer.class);

    public static void main(String[] args) throws Exception {
        ServerSocket loginServer = new ServerSocket();
        SocketAddress serverSocketAddress = new InetSocketAddress("localhost", 5230);
        loginServer.bind(serverSocketAddress);
        for (; ; ) {
            Socket socket = loginServer.accept();
            if (loginCHeck(socket)) {
                // transfer to game server thread to process
                log.info("socket check begin create thread to process");
                new GameServerThread(socket).run();
            } else {
                // authentication failed process
            }
        }
    }

    public static boolean loginCHeck(Socket socket) {
        // check authentication 
        return true;
    }
}