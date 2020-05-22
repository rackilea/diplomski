@Entity
@Data
@Table(name = "partner_details")
public class PartnerDetails {

  @Id
  @Column(name = "partner_id")
  private String partnerId;

  @OneToOne(mappedBy = "partnerDetails")
  private JWTData jwtData;


@Entity
@Data
@Table(name = "jwt_data")
@NoArgsConstructor
public class JWTData {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  // even though it looks like the entire class it's only saving the id to the database.
  @OneToOne
  private PartnerDetails partnerDetails;