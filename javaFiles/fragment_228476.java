public void ActionPerfomed(ActionEvent e) {
    // To get the source (for the game start button)
    JButton source = (Jbutton) e.getSource();

    // Get the radio button source which was selected
    // Resultantly obtain the String which it represents
    String difficulty = difficultyGroup.getSelection().getActionCommand();
}