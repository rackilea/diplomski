class MyRenderer extends DefaultListCellRenderer
{
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)
    {
        Component c = super.getListCellRendererComponent(list,value,index,false,false) ;
        JLabel label = (JLabel)c;

        label.setText(...);

        return c ;
    }
}