import java.awt.*;
import javax.swing.*;

public class MyFrame extends JFrame {

    MyPanel chatClient;
    String input;

    public MyFrame() {
        chatClient = new MyPanel("localhost","input");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(chatClient);

        pack();
        // Do last!
        setVisible(true);
    }
    public static void main(String...args){
        new MyFrame();
    }
}

class MyPanel extends JPanel{

    public MyPanel(String host, String uid) {
        ChatPanel chatPanel = new ChatPanel();
        add(chatPanel.getChatPanel());
    }
}

class ChatPanel {
    ChatP caht;

    public ChatPanel() {
        caht=new ChatP();
    }

    static class ChatP extends JPanel{
        public ChatP(){
            add(new JLabel("hi from chat panel"));
        }
    }

    public JPanel getChatPanel(){
        return caht;
    }
}