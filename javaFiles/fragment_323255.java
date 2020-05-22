public class Broadcaster {

  List<Client> clients;

  public void broadcast(Message msg) {
    for (Client client: clients)
      if (!msg.from().equals(client))
        msg.send(client);
  }
}