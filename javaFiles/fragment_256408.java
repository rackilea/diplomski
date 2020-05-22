@Audited( withModifiedFlag = true )
@Entity(name = "Customer")
public class Customer {

    ...

    @ManyToOne(fetch = FetchType.LAZY)
    private Address address;

}