/**
 * A custom node implementation.
 */
public static class ArrayNode extends AbstractMutableTreeTableNode {

    public ArrayNode(Object[] data) {
        super(data);
    }

    @Override
    public Object getValueAt(int column) {
        return getUserObject()[column];
    }

    @Override
    public void setValueAt(Object aValue, int column) {
        getUserObject()[column] = aValue;
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object[] getUserObject() {
        return (Object[]) super.getUserObject();
    }

    @Override
    public boolean isEditable(int column) {
        return true;
    }

}

// usage
ArrayNode root = new ArrayNode(new Object[] {"root", ""});
for (int i = 0; i < 5; i++) {
    root.add(new ArrayNode(new Object[]{"child", "" + i}));
}
JXTreeTable table = new JXTreeTable(new DefaultTreeTableModel(root));