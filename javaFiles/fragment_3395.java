@Embeddable
public class AddressOrder {
  @Column("street")
  private String street;
  @Column("postal_code")
  private String po;
  @Column("city")
  private String city;
  @Column("country")
  private String country;

  // Getters and setters
}