public class ListBinding extends FieldBinding {

    private Grid grid;
    private ChangeListener listener = null;
    private MemoryProxy memoryProxy = null;

    public ListBinding(Grid grid, String property) {
        super(new AdapterField(grid), property);
        this.grid = grid;
        if (!(grid.getStore().getLoader() instanceof BaseListLoader))
            return;
        BaseListLoader loader = (BaseListLoader) grid.getStore().getLoader();
        if (!(loader.getProxy() instanceof MemoryProxy))
            return;
        memoryProxy = (MemoryProxy) loader.getProxy();
    }

    @Override
    public void bind(ModelData model) {
        super.bind(model);

        if (memoryProxy == null)
            return;
        grid.getStore().removeAll();
        memoryProxy.setData(getModel().get(getProperty()));
        grid.getStore().getLoader().load();

        if (!(model instanceof BeanModel))
            return;
        BeanModel bm = (BeanModel) model;

        listener = new ChangeListener() {
            @Override
            public void modelChanged(ChangeEvent event) {
                if (!(event instanceof PropertyChangeEvent))
                    return;
                if (!property.equals(((PropertyChangeEvent) event).getName()))
                    return;
                grid.getStore().removeAll();
                memoryProxy.setData(getModel().get(getProperty()));
                grid.getStore().getLoader().load();
            }
        };
        bm.addChangeListener(listener);
    }

    @Override
    public void unbind() {
        super.unbind();
        grid.getStore().removeAll();
        if (listener == null)
            return;
        if (!(this.getModel() instanceof BeanModel))
            return;
        BeanModel bm = (BeanModel) this.getModel();
        bm.removeChangeListener(listener);
    }

    public static ListStore<BeanModel> createEmptyStore() {
        return new ListStore<>(new BaseListLoader(new MemoryProxy(new BoundList<>())/*, new BeanModelReader()*/));
    }

    public static void addListItemInBeanModel(BeanModel beanModel, String property, BeanModel newItem) {
        if (beanModel == null || !(beanModel.get(property) instanceof List) || newItem == null)
            return;
        List<BeanModel> list = beanModel.get(property);
        list.add(newItem);
        beanModel.set(property, null);
        beanModel.set(property, list);
    }

    public static void updateListItemInBeanModel(BeanModel beanModel, String property, BeanModel oldItem, BeanModel newItem) {
        if (beanModel == null || !(beanModel.get(property) instanceof List) || newItem == null || oldItem == null)
            return;
        List<BeanModel> list = beanModel.get(property);
        int index = list.indexOf(oldItem);
        if (index < 0)
            return;
        list.set(index, newItem);
        beanModel.set(property, list);
    }

    public static void removeListItemsInBeanModel(BeanModel beanModel, String property, List<BeanModel> items) {
        if (beanModel == null || !(beanModel.get(property) instanceof List) || items == null || items.isEmpty())
            return;
        List<BeanModel> list = beanModel.get(property);
        list.removeAll(items);
        beanModel.set(property, list);
    }

}