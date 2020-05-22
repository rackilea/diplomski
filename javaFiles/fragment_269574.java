JComboBox comboBox = new JComboBox(...);
Object child = comboBox.getAccessibleContext().getAccessibleChild(0);

if (child instanceof BasicComboPopup)
{
    BasicComboPopup popup = (BasicComboPopup)child;
    JList list = popup.getList();
    list.addMouseListener(...);
}