@Document
public class CollectionSeq {
    @Id
    @Indexed( unique = true)
    private String collection;
    private long current = 1;
}