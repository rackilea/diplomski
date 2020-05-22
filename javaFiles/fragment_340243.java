import java.util.ArrayList;
import java.util.Scanner;

public class Store {
    ArrayList<Customer> Customers = new ArrayList<Customer>();
   Customer[] csa = new Customer[1000];

    public void addSale(String customerName, double amount) {
   String cn = customerName;
   double am = amount;
   Customer cs = new Customer(cn, am);
   Customers.add(cs);
}

public String nameOfBestCustomer() {
   String name = null;
   //Customer csa=new Customer();
   double largest = Customers.get(0).getAmount();

   // gives me:java.lang.NullPointerException

   for (int i = 1; i < Customers.size(); i++) {

       if (largest < Customers.get(i).getAmount()) {
           largest = Customers.get(i).getAmount();
           name = Customers.get(i).getName();
       }
   }

   // return name+""+largest;
   return name;
}


public static void main(String[] args) {

   Store s = new Store();
   double am;

   Scanner scanner = new Scanner(System.in);

   while (true) {

       System.out.println("Enter Customer name:");
       String cn = scanner.next();

       if (cn.equals("done")) {
           am = 0;
           scanner.close();

           break;
       } else {
           System.out.println("Enter Amount:");
           am = scanner.nextDouble();
           s.addSale(cn, am);

       }
   }

   System.out.println("Best customer " + s.nameOfBestCustomer());

}

           }

class Customer {
private String name;
private double amount;


public Customer(){

}
//@SuppressWarnings("null")
public  Customer(String name,double price) {
    this.name=name;
    this.amount= price;

}





public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}
public double getAmount() {
    return amount;
}
public void setAmount(double amount) {
    this.amount = amount;
}

                 }




Output :
Enter Customer name:
ramesh
Enter Amount:
100
Enter Customer name:
pramod
Enter Amount:
200
Enter Customer name:
done
Best customer pramod