for(JComponent control : parentPanel.getComponents())
{
    if(control instanceof JTextField)
    {
        JTextField ctrl = (JTextField) control;
        ctrl.setText("");
    }
    else if (control instanceof JComboBox)
    {
        JComboBox ctr = (JComboBox) control;
        ctrl.setSelectedIndex(0);
    }
}