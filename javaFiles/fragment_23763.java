public class TextCellEdit extends AbstractCellEditor implements TreeCellEditor {

private JComboBox<Object> box;
private JLabel label;
private JPanel panel;
private FieldObj my;

public Component getTreeCellEditorComponent(JTree tree, Object value,
        boolean isSelected, boolean expanded, boolean leaf, int row) {

    if (value != null && value instanceof DefaultMutableTreeNode) {
        Object userObject = ((DefaultMutableTreeNode) value)
                .getUserObject();
        if (userObject instanceof FieldObj) {
            my = (FieldObj) userObject;
            box.removeAllItems();
            label.setText(my.FieldName);
            populatebox(my.FieldName);
            box.addItem(my.valueList);
            panel.add(label);
            panel.add(box);
        } else {
            box.addItem("Uknown object type");
        }
        return panel;
    }
}

public Object getCellEditorValue() { 
    System.out.println("getCellEditoValue returns :" + box.getSelectedItem());
    my.FieldName = box.getSelectedItem();
    return box.getSelectedItem();
}
}