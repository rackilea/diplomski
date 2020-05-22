public class Page implements Serializable {
    private String name;
    private List<Page> children;
    private transient GraphDatabaseService dbService;

    // Constructors, Getters/Setters
}