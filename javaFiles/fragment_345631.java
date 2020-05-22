@Entity
@Table("Address")
public class Address {
    @Id //<-need to specify a generator here 
    private Long id;
    String addressLine; 
    String city;
    String pinCode;

    @ElementCollection
    @CollectionTable(name = "Phone", joinColumns = @JoinColumn(name = "ADDRESS_ID"), foreignKey = @ForeignKey(name = "PHONE_Address_FK"))
    List<String> phoneNo;
}