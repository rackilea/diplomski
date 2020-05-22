public class BlackJack{
    private Client client;

    public BlackJack(){
        // Setup Client class, which will be passed to all other classes
        client = new Client(server, port, username);

    }