public void actionPerformed(ActionEvent ae) {
    Font currentFont = taText.getFont(); //taText is TextArea
    Font fontToSet;
    String command = ae.getActionCommand();
    if (command.equals("Italic")) {
        System.out.println("Italic clicked");
        fontToSet =currentFont .deriveFont(Font.ITALIC);
    else {
        System.out.println("Plain clicked");
        fontToSet = currentFont .deriveFont(Font.PLAIN);
    }
    taText.setFont(fontToSet);
}