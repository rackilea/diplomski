@Entity
public class Position {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  private Long latitude;
  private Long longitude;

  @OneToOne
  private Store store;

  protected Position() {}

  public Position(long latitude, longitude, Store store) {
    this.latitude = latitude;
    this.longitude = longitude;
    this.store = store;
  }

  // Standard Getters and Setters
}