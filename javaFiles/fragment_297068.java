class tfListener implements ActionListener
{
private final String tf1text;
private final String tf2text;


public tfListener(JTextField tf1, JTextField tf2)
{
    tf1text = new String(tf1.getText());
    tf1text = new String(tf2.getText());

}

@Override
public void actionPerformed(ActionEvent e)
{
    if(tf1text.equal(tf2text))
    {
        JOptionPane.showMessageDialog(null, "equal");
    }
    else
    {
        JOptionPane.showMessageDialog(null, "not equal");
    }
}