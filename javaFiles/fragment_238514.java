public void actionPerformed(ActionEvent e)
{
    if (e.getActionCommand().equals(CMD_PRESSED_B1)
    {
        //Do something!
        OtherClass other = new OtherClass();
        other.myMethod();
    }

    else if (e.getActionCommand().equals(CMD_PRESSED_B2)
    {
        //Do something else!
        ...
    }
}