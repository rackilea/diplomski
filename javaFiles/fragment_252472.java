@Entity
@Table(name = "orderline")
public class OrderLine implements Serializable {

@Id
@Column(name = "OrderLineID")
@GeneratedValue(strategy = GenerationType.IDENTITY)
Integer orderLineID;

@ManyToOne
@JoinColumn(name = "OrderHeaderID")
OrderHeader orderHeader;
}

...

@Entity
@Table(name = "orderheader")
public class OrderHeader implements Serializable {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "OrderHeaderID")
int orderHeaderId;

@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy="orderHeader")
List<OrderLine> orderLineList;
}