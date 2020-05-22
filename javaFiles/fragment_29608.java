public class User{
    ...
    @OneToOne(CascadeType.REMOVE)//this is for to remove address when user is removed
    @JoinColumn(name="HOME_ADDRESS_ID")
    private Address address;
    ...
}