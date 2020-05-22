@Entity
@Access(AccessType.FIELD)
public class Item {

    private static final long FACTOR = 5;

    @Id
    private long id;

    private String name;

    @Transient
    private long amount;

    // getter and setters for id and name

    @Access(AccessType.PROPERTY)
    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount * FACTOR;
    }
}