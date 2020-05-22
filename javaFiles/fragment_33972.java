@Entity
@Table(name = "CONNECTION")
public class Connection implements Serializable {
  @Id
  @NotNull
  @Column(name = "CONNECTION_ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer connectionId;

  @NotNull
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "CONNECTION_TYPE_ID", referencedColumnName = "CONNECTION_TYPE_ID")
  private ConnectionType connectionType;

  @NotNull
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "RELATED_USER_ID", referencedColumnName = "USER_ID")
  private User relatedUser;

  @NotNull
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "RELATING_USER_ID", referencedColumnName = "USER_ID")
  private User relatingUser;

  ...
}