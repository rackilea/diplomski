@Entity
@Table(name="test_address")
public class Address 
{
    @Id
    @Column(name="user_id")
    protected int userId;

    @OneToOne
    @PrimaryKeyJoinColumn(name="user_id", referencedColumnName="id")
    protected PmoUser owner;

    @Column(name="address")
    protected String address;


    public void setOwner(PmoUser owner) 
    {
        this.owner = owner;
        this.userId = owner.getId();
    }


    @Override
    public String toString() {
        return "Address [userId=" + userId + ", owner=" + owner + ", address=" + address + "]";
    }    

}