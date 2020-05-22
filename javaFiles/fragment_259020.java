@Entity
public class Faehrfahrt {

   @JsonIgnore
   @ManyToOne
   @JoinColumn(name = "faehre_id")
   private Faehre faehre;

   @OneToMany(cascade = CascadeType.ALL, mappedBy = "faehrafhrt")
   private List<Buchung> buchungen = new ArrayList<>();

}