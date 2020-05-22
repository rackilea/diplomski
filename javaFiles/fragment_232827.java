@Entity
@Table(schema="xxx", name="ITEM")
public class Item {
    @Id
    @Column(name = "adID")
    private Long id;

    @OneToOne(optional=true, fetch=FetchType.LAZY)
    @JoinColumn(name="adID", unique=true, nullable=false, updatable=false)
    private Ad ad;

    @OneToMany(mappedBy = "item")
    private List<Booking> bookings;
}