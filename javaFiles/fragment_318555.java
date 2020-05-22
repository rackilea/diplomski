@Entity
@Table(name="CUSTOMER")
@SecondaryTable(name="CUST_DETAIL", 
            pkJoinColumns=@PrimaryKeyJoinColumn(name="CUST_DETAIL_ID", referencedColumnName = "CUST_DETAIL_ID"))
public class Customer {
    @Id
    @Column(name = "CUST_ID")
    private Long id;

    @Column(name = "CUST_DETAIL_ID", table = "CUSTOMER")
    private Long custDetailId;

    @Column(name = "CUST_DETAIL_ID", table = "CUST_DETAIL")
    private Long custDetailPk;

    ...
}