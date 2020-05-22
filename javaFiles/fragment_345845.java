@Getter
@Entity
@Table(name = "addresses")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE addresses SET deleted = true, updated_at = current_date WHERE id = ?")
public class Address extends Auditable implements Serializable {

    private static final long serialVersionUID = -5034153190245766924L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(name ="userId", nullable = true)
    private Long userId;

    @Setter
    @Column(name = "country", nullable = false)
    private String country;

    @Setter
    @Column(name = "state", nullable = false)
    private String state;

    @Setter
    @Column(name = "city", nullable = false)
    private String city;

    @SuppressWarnings("PMD.AvoidFieldNameMatchingTypeName")
    @Setter
    @Column(name = "address", nullable = false)
    private String address;


    public Address(Address address) {}
}