private void restartButtonActionPerformed(ActionEvent evt)  {
    if(evt.getSource() == restartButton)
    {
        dispose();
        MyGUI game = new MyGUI();
        game.setVisible(true);
    }
}