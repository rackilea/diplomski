public class ConfigurationItems {

    @Action(semantics = SemanticsOf.SAFE)
    public SelectedItems listAll() {
        List<T> items = repositoryService.allInstances(<item-subclass>.class);
        return new SelectedItems(items);
    }
}