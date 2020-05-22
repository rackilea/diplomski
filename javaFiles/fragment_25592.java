public class Server
{
    static TClient[] connexions = new TClient[2];

    public static void send(int clientNum, String message) {
        TClient t = connexions[clientNum];
        if(t != null) {
            t.getOut().println(message);
            t.getOut().flush();
        }
    }

}