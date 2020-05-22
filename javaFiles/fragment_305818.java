public class JavaApplication3 extends JFrame {

private final JTextArea chatbox = new JTextArea();

public JavaApplication3() {

    // ... Your stuff

    chatbox.setEditable(false);

    // ... More stuff
}

public appendToChatbox(String s) {
    chatbox.append(s);
}

public static void main(String[] args) {
    JavaApplication3 myframe = new JavaApplication3();
    myframe.appendToChatbox("hi");
}