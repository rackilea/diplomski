public class ChatGUI{
    private JTextArea textarea;
    private Client client;

    public ChatGUI(Client c){
        client = c;
    }

    //receive message/command from server
    public void newMessage(String msg){
        //perform the desired action based on the command
    }

    public void sendChat(String msg){
        client.sendChat(msg);
    }
}

public class GameGUI{
    private Client client;

    public GameGUI(Client c){
        client = c;
    }

    //receive message/command from server
    public void newMessage(String msg){
        //perform the desired action based on the command
    }
}