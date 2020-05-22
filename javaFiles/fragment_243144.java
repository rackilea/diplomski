@Document(name = "task")
@CompoundIndexes({
        @CompoundIndex(def = "{'contract': 1, 'executionAt': 1}"),
        @CompoundIndex(def = "{'contract': 1, 'name': 1}")
})
public abstract class Task {

    @Id
    private String id;

    @DBRef
    @Indexed
    private Contract contract;

    private String name;

    private Instant executionAt;
}