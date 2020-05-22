class MRUComboBoxModel extends DefaultComboBoxModel {

    @Override
    public void addElement(Object element) {
        this.insertElementAt(element, 0);
    }

    @Override
    public void insertElementAt(Object element, int index) {
        super.insertElementAt(element, 0);
        int size = this.getSize();
        if (size > 10) {
            this.removeElementAt(size - 1);
        }
    }
}