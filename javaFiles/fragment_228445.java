@Entity   
public class Client {

@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private Integir id;
private String name;
@JsonManagedReference
@ManyToMany(cascade = CascadeType.ALL)
@JoinTable(****)
private List<Phone> phones = new ArrayList<>();
**gets and sets**

   public Client (){}
   public Client (String name){
    this.name = name;
   }
}