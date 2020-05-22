public class Item {
    private Long id;

    class FromArchived extends Item {
        public FromArchived(final ArchivedItem archived) {
            this.id = archived.getId();
        }
    }
}