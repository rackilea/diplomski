@Entity
@Table(name = "citizens")
public class Citizen {
  @Id
  @Size(max = 10, min = 10, message = "CPR must be exactly 10 characters")
  private String cpr;

  @OneToMany(
      mappedBy = "citizen",
      cascade = CascadeType.ALL, //cascade all operations to children
      orphanRemoval = true //remove orphaned WeeklyCare if they don't have associated Citizen
  )
  private List<WeeklyCare> weeklyCares = new ArrayList<>(); //init collections to avoid nulls

    //constructors, getters, setters

    //add utility methods to manipulate the relationship

    public void addWeeklyCare(WeeklyCare weeklyCare) {
      weeklyCares.add(weeklyCare);
      weeklyCare.setCitizen(this);
    }

    public void removeWeeklyCare(WeeklyCare weeklyCare) {
      weeklyCares.remove(weeklyCare);
      weeklyCare.setCitizen(null);
    }
}