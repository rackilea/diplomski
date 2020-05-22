@Entity
public class Passagier {

   @OneToMany(cascade = CascadeType.ALL,mappedBy = "passagier")
   private List<Buchung> buchungen = new ArrayList<>();

}