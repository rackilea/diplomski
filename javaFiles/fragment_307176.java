public class Checkout {
    public ArrayList<Customers> custList = new ArrayList<>();
    ....

public static void main(String[] args){
    ArrayList<Checkout> chkouts = new ArrayList<>();

    chkouts.add(new Checkout());
    chkouts.get(0).custList.add(new Customer());