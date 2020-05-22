public class FileOperationListModel extends AbstractListModel<FileOperation> {

    private List<FileOperation> items = new ArrayList<FileOperation>(25);
    private PropertyChangeListener handler = new PropertyChangeHandler();

    public void add(FileOperation fo) {
        fo.addPropertyChangeListener(handler);
        int size = items.size();
        items.add(fo);
        fireIntervalAdded(this, size, size);
    }

    public void remove(FileOperation fo) {
        int index = items.indexOf(fo);
        if (index < 0) {
            return;
        }
        fo.removePropertyChangeListener(handler);
        items.remove(fo);
        fireIntervalRemoved(this, index, index);
    }

    @Override
    public int getSize() {
        return items.size();
    }

    @Override
    public FileOperation getElementAt(int index) {
        return items.get(index);
    }

    public class PropertyChangeHandler implements PropertyChangeListener {

        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            if (!(evt.getSource() instanceof FileOperation)) {
                return;
            }
            FileOperation fo = (FileOperation) evt.getSource();
            int index = items.indexOf(fo);
            fireContentsChanged(FileOperationListModel.this, index, index);
        }

    }

}