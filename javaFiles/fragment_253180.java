public class AutomatedTreeItem<C, D> extends TreeItem<D> {
    public AutomatedTreeItem(C container, Function<C, D> dataFunction, Function<C, Collection<? extends C>> childFunction) {
        super(dataFunction.apply(container));
        getChildren().addAll(childFunction.apply(container)
                .stream()
                .map(childContainer -> new AutomatedTreeItem<C, D>(childContainer, dataFunction, childFunction))
                .collect(Collectors.toList()));
    }
}