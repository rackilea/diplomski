@Entity
@Table(name="UserOrderDetails")
public class UserOrderDetails {

   //Need to have identity generator of your wish

    @Id
    @Column(name = "TRANSACTION_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String transactionId;   
    private Timestamp CreationDateTime; 

   **@Column(name = "NO_OF_ITEMS_SELECTED")**
    private int noOfItemsSelected; 

   **@Column(name = "NO_OF_ITEMS_DISP")** 
    private int noOfItemsDispatched;
    //Getters and Setters