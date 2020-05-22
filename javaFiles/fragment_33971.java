@Entity
@Table(name = "CONNECTION_TYPE")
public class ConnectionType implements Serializable {
  @Id
  @NotNull
  @Column(name = "CONNECTION_TYPE_ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer connectionTypeId;

  @NotNull
  @Column(name = "CONNECTION_TYPE_NAME", unique = true)
  private String connectionTypeName;

  @Column(name = "CONNECTION_TYPE_DESCRIPTION")
  private String connectionTypeDescription;

  ...
}