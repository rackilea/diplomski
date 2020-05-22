public class ItemTree extends Composite implements Serializable, IsWidget {

    ...

    public ItemTree(Categoria categoria) {
        this.id = categoria.getId();
        this.description = categoria.getDescription();
        this.level = categoria.getLevel();
        initWidget(new Label(getDescription()));    // <- !!!
    }

    ...
}