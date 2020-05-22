@Embeddable
public class ItemDetail implements Serializable
{
    @Temporal(DATE)
    private Date date;

    @Column
    private Double priceA;

    @Column
    private Double priceB;

    // getters/setters
}