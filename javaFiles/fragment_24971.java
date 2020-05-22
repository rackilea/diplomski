FocusAdapter fl = new FocusAdapter()
{
    public void focusGained (FocusEvent evt)
    {
        if (evt.getSource() == txtField1)
            txtField2.setText("");
        else if (evt.getSource() == txtField2)
            txtField1.setText("");
    }
}
txtField1.addFocusListener(fl);
txtField2.addFocusListener(fl);