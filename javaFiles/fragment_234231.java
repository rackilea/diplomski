@Override
public void actionPerformed(ActionEvent e)
{
    KeyboardFocusManager kfm = KeyboardFocusManager.getCurrentKeyboardFocusManager();
    Component focusedComponent = kfm.getFocusOwner();

    if (focusedComponent instanceof JTextArea)
        return;

    JOptionPane.showMessageDialog(panel, "You pressed a button \n"+e.paramString());
}