public class Buyer{
    private String name;
    private Address address;

public Buyer(String nm){
        name = nm;
        address = new Address();
}
public void changeAdress(){
           address.change();   
}
}