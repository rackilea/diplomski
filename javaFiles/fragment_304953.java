public class MyCustomTreeModel implements TreeViewModel {

    private final SelectionModel<Item> selectionModel;
    private final ValueUpdater<Item> valueUpdater;

    public MyCustomTreeModel(final SelectionModel<Item> selectionModel, ValueUpdater<Item> valueUpdater) {
        this.selectionModel = selectionModel;
        this.valueUpdater = valueUpdater;
    }

    @Override
    public <T> NodeInfo<?> getNodeInfo(final T value) {
        // The root node is the container
        ListDataProvider<Item> = new ListDataProvider<Item>();
        if (value instanceof Container) {
            provider.setList(((Container)value).getItemList();
            return new DefaultNodeInfo<Item>(provider, containerCell, selectionModel,null);
        }
        provider.setList(((Item)value).getChilds());
        return new DefaultNodeInfo<Item>(provider, itemCell, selectionModel, valueUpdater);
    }

    @Override
    public boolean isLeaf(Object value) {
        Item item = (Item) value;
        return value != null && item.getChild().size() == 0;
    }
}