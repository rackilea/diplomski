@Override
public void actionPerformed(ActionEvent e)
{
    Object source = e.getSource();
    if (source instanceof JButton) {
        JButton btn = (JButton)source;
        String butSrcTxt = btn.getText();
    }

}