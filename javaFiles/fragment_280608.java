class ModelCellModifier implements ICellModifier {
    TableViewer viewer;

    public ModelCellModifier(TableViewer viewer) {
        this.viewer = viewer;
    }

    @Override
    public boolean canModify(Object element, String property) {
        // property is defined by viewer.setColumnProperties()
        // allow the FOO column can be modified.
        return "foo_prop".equals(property);
    }

    @Override
    public Object getValue(Object element, String property) {
        if ("foo_prop".equals(property)) {
            return ((Model) element).getFoo();
        }
        if ("bar_prop".equals(property)) {
            return ((Model) element).getBar();
        }
        return "";
    }

    @Override
    public void modify(Object element, String property, Object value) {
        if ("foo_prop".equals(property)) {
            TableItem item = (TableItem) element;
            ((Model) item.getData()).setFoo("" + value);

            // refresh the viewer to show the changes to our user.
            viewer.refresh();
        }
    }
}