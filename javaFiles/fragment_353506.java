@Entity
@Table(name = "item", catalog = "myshchema")
public class Item implements java.io.Serializable {

@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true, mappedBy="item")
private Set<ItemCategory> categories; //`mappedBy`used here because this entity is not the owner of the relationship according to what mentioned above

/* Getters and Setters and other fields*/
}