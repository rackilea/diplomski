@Entity 
public class Transaction {

    @Id @GeneratedValue public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    private Integer id;

    // ... snip ...

    @OneToMany(mappedBy="transaction")
    @MapKey(name="name")
    public Map<String, String> getProperties(){
    return properties;
    }
    public void setProperties(Map<String, String> prop){
    properties = prop;
    }
    private Map<String, String> properties; // NB: Type has to be <String, String> because the column name is a String and you have defined the property value to be a String.

    public void setProperty(Properties property, String value){
    properties.put(property, value);
    }
    public String getProperty(String name){
    return (String) properties.get(property);
    }
}

@Entity
public class Property {
    @Id @GeneratedValue public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    private Integer id;

    @ManyToOne
    public Transaction getTransaction() { return transaction; }
    public void setTransaction(Transaction transaction) { this.transaction = transaction; }
    private Transaction transaction;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    private String name;

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    private String description;

}