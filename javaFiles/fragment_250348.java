public class Client{
    private ChatGUI chatgui;
    private GameGUI gamegui;

    Client(String server, int port, String username){
             chatgui = new ChatGUI(this);
             gamegui = new GameGUI(this);
    }

    //handle messages from server
    void onMessageRecieved(String msg){
            if(/* the message pertains to the game gui */ )
                    gamegui.newMessage(msg);
            else if( /* the message pertains to the chat gui */ )
                    chatgui.newMessage(msg);
    }

    //here you can add functions for the gui classes to call
    public void sendChat(String chat){

    }
}