public enum CONSIGNEE_TYPE {
      INTERMEDIATE,
      ULTIMATE
}

@Entity
@Table(name = "Consignee")
public class Consignee extends Model {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   public Long id;

   public String name;

   public String address;

   @Enumerated(EnumType.ORDINAL)
   public CONSIGNEE_TYPE type;

   @Column(name="item_id")
   @OneToMany(cascade = CascadeType.ALL, mappedBy = "consignee", fetch = FetchType.EAGER)
   public List<Item> item = new ArrayList<Item>();

   //TODO: Generate Constructors/Getters/Setters
}

@Entity
@Table(name = "Item")
public class Item extends Model {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   public Long id;

   public String name;

   @ManyToOne(optional = false, fetch = FetchType.EAGER)
   public Consignee consignee = new Consignee();

   //TODO: Generate Constructors/Getters/Setters
}