class Clients {

 private final Set<ClientDetails> clients = new HashSet<>();

 public boolean checkClientExists(InetAddress ip, int port, String name){

   return  clients.contains(new ClientDetails(ip,port,name));   

 }

//More code for client management.
}