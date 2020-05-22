@Entity(name = "Post")
@Table(name = "post")
public static class Post implements Identifiable<String> {

    @Id
    @GenericGenerator(
        name = "assigned-sequence",
        strategy = "com.vladmihalcea.book.hpjp.hibernate.identifier.StringSequenceIdentifier",
        parameters = @org.hibernate.annotations.Parameter(name = "sequence_name", value = "hibernate_sequence")
    )
    @GeneratedValue(generator = "assigned-sequence", strategy = GenerationType.SEQUENCE)
    private String id;

    @Version
    private Integer version;

    public Post() {
    }

    public Post(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }
}