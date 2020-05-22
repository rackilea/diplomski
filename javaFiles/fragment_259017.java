@Entity
public class Buchung { 

   @JsonIgnore
   @ManyToOne
   @JoinColumn(name = "faehrfahrt_id")
   private Faehrfahrt faehrfahrt;

   @JsonIgnore
   @ManyToOne
   @JoinColumn(name = "passagier_id") 
   private Passagier passagier;

}