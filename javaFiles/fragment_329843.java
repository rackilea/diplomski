public class Item {
    private Long id;

    public static Item fromArchived(final ArchivedItem archived) {
        return new Item(){{
            this.id = archived.getId();
        }};
    }
}