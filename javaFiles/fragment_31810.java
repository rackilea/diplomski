public class Server {
    public void main(final String ... $Args) {
         final Server S = new Server();
         S.config($Args);
         S.run();
    }
}

public class Client {
    public void main(final String ... $Args) {
         final Client C = new Client();
         C.config($Args);
         C.run();
    }
}

public class Test_ServerClient {
    public void main(final String ... $Args) {
         Server.main('server1.cfg');
         Client.main('client1.cfg');
         Client.main('client2.cfg');
    }
}