public void actionPerformed(ActionEvent evt)
{
    JButton button = (JButton)evt.getSource();
    Component parent = button.getParent();

    if (button == redBtn)
        parent.setBackground( Color.RED );
    else if (...)
}