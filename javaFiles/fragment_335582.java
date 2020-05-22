public class User {
    public int id;
    public String name;

    @JsonBackReference
    public List<Item> userItems; 
} 

public class Item {
    public int id;
    public String itemName;

    @JsonManagedReference
    public User owner; 
 }