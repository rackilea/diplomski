public class EntryWrapper {
    @Id
    private long id;

    @Embedded
    private Entry entry;
}