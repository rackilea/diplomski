@Entity
public class Faehre {    

   @OneToMany(cascade = CascadeType.ALL, mappedBy="faehre")
   private List<Faehrfahrt> faehrfahrten = new ArrayList<>();

   @JsonIgnore
   @ManyToOne
   @JoinColumn(name = "strecke_id")
   private Strecke strecke;

}