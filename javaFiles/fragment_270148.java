class ClickListener extends JButton implements ActionListener
{
    public void actionPerformed(ActionEvent event)
    {
      //this is where I want to grab and assign the text
      letter = this.getText();
      checker(word, letter); //this compares with the hangman word
      setEnabled(false);//I want to disable the button after it is clicked
    }   
}


for(int i = 0; i < 26; i++)
{
    // When you do this, ClickListener is a NEW instance of a JButton with no
    // text, meaning that when you click the button and the actionPerformed
    // method is called, this.getText() will return an empty String.
    letters[i].addActionListener(new ClickListener());
    gamePanel.add(letters[i]);
}