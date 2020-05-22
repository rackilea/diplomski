class ChatWindow extends JFrame {
JTextArea messageField; //This line does the trick!

public ChatWindow () {
    setLayout(new BorderLayout());

    //A JPanel containing the "message board";
    JPanel messageBoard = new JPanel(new FlowLayout());

    //A JTextArea showing all the messages.
    messageField =  new JTextArea();
    messageField.setPreferredSize(new Dimension(470, 300));
    messageField.setMargin(new Insets(10, 10, 10, 10));
    messageBoard.add(messageField);
    add(messageBoard, BorderLayout.NORTH);

    //A JPanel containing the TextField where the user writes his messages as well as the button to send these messages
    JPanel typeBoard = new JPanel(new FlowLayout());

    //A JTextArea where the user writes his messages.
    JTextArea typeField = new JTextArea();
    typeField.setPreferredSize(new Dimension(350, 100));
    typeField.setMargin(new Insets(10, 10, 10, 10));
    typeBoard.add(typeField);

    //A button used to send a message.
    JButton sendButton = new JButton("Send");
    sendButton.setPreferredSize(new Dimension(100, 100));
    typeBoard.add(sendButton);

    add(typeBoard, BorderLayout.SOUTH);

    setSize(500, 470);
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);        
 }