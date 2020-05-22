@Entity
public class Orders {
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private User user;

  @Embedded
  private AddressOrder address;

  // Getters and setters
}