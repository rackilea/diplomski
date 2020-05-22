@Entity
@Table(name = "USER_INFO")
public class User implements Serializable {
  @Id
  @NotNull
  @Column(name = "USER_ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer userId;

  @NotNull
  @Column(name = "USER_NAME")
  private String userName;

  @NotNull
  @Column(name = "PASSWORD")
  private char[] password;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "relatedUser", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Connection> connections;
}