public class MyComboBoxModel extends AbstractListModel implements ComboBoxModel {

    private List data;
    private Object selectedItem;
    public MyComboBoxModel(List dat) {
        this.data = data;
    }

    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public Object getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem = anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }

}