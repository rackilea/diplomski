@Entity
public class Phone {

@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private Integir id;
private String number;
@JsonBackReference
@ManyToMany(mappedBy = "phones")
private List<Client> clients = ArrayList<>();
**gets and sets**

    public Phone() {}
    public Phone(String number) {
      this.number = number;
    }  
}