class ModelLabelProvider extends LabelProvider implements
        ITableLabelProvider {

    @Override
    public Image getColumnImage(Object element, int columnIndex) {
        // no image to show
        return null;
    }

    @Override
    public String getColumnText(Object element, int columnIndex) {
        // each element comes from the ContentProvider.getElements(Object)
        if (!(element instanceof Model)) {
            return "";
        }
        Model model = (Model) element;
        switch (columnIndex) {
        case 0:
            return model.getFoo();
        case 1:
            return model.getBar();
        default:
            break;
        }
        return "";
    }
}