@Entity
@Table(name = "Order_")
public class Order implements Serializable {
....... 
@ManyToMany
@Cascade({CascadeType.PERSIST})
@JoinTable(name = "product_order", 
        joinColumns = { @JoinColumn(referencedColumnName="id") }, 
        inverseJoinColumns = { @JoinColumn(referencedColumnName="id") })
private List<Product> products;
.......
}


@Entity
@Table(name = "Product")
public class Product implements Serializable {
.......
@Cascade({CascadeType.PERSIST})
@ManyToMany(mappedBy="products")
private List <Order> orders;
.......
}