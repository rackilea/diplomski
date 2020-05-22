public class ListModifyingChangeListener implements ChangeListener<String> {
    private final int index;
    private final List<String> list;

    public ListModifyingChangeListener(int index, List<String> list) {
        this.index = index;
        this.list = list;
    }

    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        list.set(index, newValue);
    }

}