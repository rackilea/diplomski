public void actionPerformed(ActionEvent evt) {
    Object src = evt.getSource();
    String playerName = jTextFieldPlayerName.getText();

    if (src == startText1Continue && playerName.length() > 0) {     
        System.out.println("Your name is: " +playerName);   
    }
}