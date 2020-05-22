@Data
@Embeddable
public class ItemDetail  implements Serializable{
 @Id
 private String serialNumber;

 private String itemDescription;

 private int itemQuantity;

 private float itemRate;

 private float amount;

 }