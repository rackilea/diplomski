public final class Employee{
    private final int id;
    private final Address address;
    public Employee(int id, Address address)
    {
        this.id = id;
        this.address=new Address();  // defensive copy
        this.address.setStreet( address.getStreet() );
    }
    public int getId(){
        return id;
    }
    public Address getAddress() {
        Address nuAdd = new Address(); // must copy here too
        nuAdd.setStreet( address.getStreet() );
        return nuAdd;
}