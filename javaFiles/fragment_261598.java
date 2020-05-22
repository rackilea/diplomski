class listener implements ActionListener
{
    public void actionPerformed(ActionEvent event)
    {
        if (event.getSource() instanceof JComboBox) {
            JComboBox cb = (JComboBox)event.getSource();
            System.out.println(cb.getSelectedItem());
        }
    }
}