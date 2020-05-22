ClickListener handler = new ClickListener();
for(int i = 0; i < 26; i++)
{
    letters[i].setActionCommand(letters[i].getText());
    letters[i].addActionListener(handler);
    gamePanel.add(letters[i]);
}

class ClickListener implements ActionListener
{
    public void actionPerformed(ActionEvent event)
    {
      letter = event.getActionCommand();
      checker(word, letter); //this compares with the hangman word
      setEnabled(false);//I want to disable the button after it is clicked
    }   
}