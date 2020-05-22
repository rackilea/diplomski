private JButton _lastButtonPressed;    

void actionPerformed(ActionEvent event)
{
    JButton buttonPressed = (JButton) event.getSource();
    if (_lastButtonPressed == buttonPressed)
    {
        //The same button was clicked two+ times in a row
    }
    else
    {
        //code for handling single button presses
    }
    _lastButtonPressed = buttonPressed;
}