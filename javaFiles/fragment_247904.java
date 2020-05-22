@Entity
@Where(clause = "active='true'")
public class Customer {
    //...
    @Column
    private Boolean active;
}