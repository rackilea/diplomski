public class Network {

    static public final int tcpPort = 54555;
    static public final int udpPort = 54777;

    // This registers objects that are going to be sent over the network.
    static public void register (EndPoint endPoint) {
        Kryo kryo = endPoint.getKryo();
        kryo.register(ServerResponse.class);
        kryo.register(ClientRequest.class); 

    }

    static public class ServerResponse {
    ...
       public ServerResponse(){
               super();
       }
...
    }

    static public class ClientRequest {
    ...
        public ClientRequest(){
               super();
        }
    ...
   }
...
}