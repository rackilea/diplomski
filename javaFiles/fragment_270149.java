class ClickListener implements ActionListener
{
    public void actionPerformed(ActionEvent event)
    {
      letter = ((JButton)event.getSource()).getText();
      checker(word, letter); //this compares with the hangman word
      setEnabled(false);//I want to disable the button after it is clicked
    }   
}