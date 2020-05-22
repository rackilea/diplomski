public class SomePersistableItem extends SomeItem
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    public SomePersistableItem(SomeItem originalItem) {
        super(originalItem.getName(), originalItem.getSize());
    }