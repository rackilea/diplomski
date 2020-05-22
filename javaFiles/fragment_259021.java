@Entity
public class Strecke {

   @OneToMany(cascade = CascadeType.ALL, mappedBy="strecke")
   private List<Faehre> faehren = new ArrayList<>();

}