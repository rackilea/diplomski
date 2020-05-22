public class Item {
    private Long id;

    public static Item fromArchived(final ArchivedItem archived) {
        Item item = new Item();
        item.id = archived.getId();
        return item;
    }
}