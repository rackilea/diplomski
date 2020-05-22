@Embeddable
public class MyKey implements Serializable {

    @Column(name = "Id", nullable = false)
    private int id;

    @Column(name = "Version", nullable = false)
    private int version;

    /** getters and setters **/
}