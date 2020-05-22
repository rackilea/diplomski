@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "drivers")
public class Driver implements Persistable<Long> {

    @Id private Long id;

    private String firstName;
    private String lastName;
    private String middleName;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "carrierId", foreignKey = @ForeignKey(name = "drivers_carriers"))
    private Carrier carrier;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumns(
            value = {@JoinColumn(name = "locationId"), @JoinColumn(name = "locationName")},
            foreignKey = @ForeignKey(name = "drivers_locations")
    )
    private Location location;

    @Override
    public boolean isNew() {
        return true;
    }
}