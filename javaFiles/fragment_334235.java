public interface Address {
    String getAddress();
}
class AddressImpl implements Address {
    String address;
    public AddressImpl(String address){
        this.address = address;
    }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}
...
public List<Address> getAddresses(){
    List<Address> addressesToReturn = new ArrayList<Address>();
    for(Address address : addresses){
        addressesToReturn.add(address); //i.e. return the original object as is
    }
    return addressesToReturn;
}