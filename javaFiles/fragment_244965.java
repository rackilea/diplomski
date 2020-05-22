@Entity
public class YourEntity {
    @EmbeddedId
    private MyKey myKey;

    @Column(name = "ColumnA")
    private String columnA;

    /** Your getters and setters **/
}