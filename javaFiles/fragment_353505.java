@Entity
@Table(name = "item_category")
public class ItemCategory {

@Id
private Integer categoryId;

private Store store;

@ManyToOne
@JoinColumn(name="item_id", /*cascade = ...*/)
private Item item;

private String categoryName;

/* Getters and Setters */
}