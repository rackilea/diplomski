public Gui(){
    frame = new JFrame();
    frame.setSize(600, 400);

    textfield = new JTextArea();
    textfield.setText("Textfield");
//    textfield.setSize(400, 300);

    JPanel messagePanel = new JPanel(new BorderLayout());

    JTextField chatMessage = new JTextField("Send me");
    JButton send = new JButton("Send");

    messagePanel.add(chatMessage, BorderLayout.CENTER);
    messagePanel.add(send, BorderLayout.EAST);

    frame.add(textfield, BorderLayout.CENTER);
    frame.add(messagePanel, BorderLayout.SOUTH);
    frame.setVisible(true);
}