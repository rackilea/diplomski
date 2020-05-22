@Entity
public class WeeklyCare {

  @Id
  @GeneratedValue
  private Long id;

  @Embedded
  private WeeklyCareIdentifier weeklyCareIdentifier;

  //constructors, getters, setters
}