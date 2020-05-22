@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name="TRANSACTION_DETAIL")
public class TransactionDetail {

    @Id
    @Column(name="UUID", updatable=false)
    private String uuid;


    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="FK_TRANSACTION")
    private Transaction transaction;

    @Column(name="ACCOUNT_NO")
    private int accountNo;

  // other fields goes here

}