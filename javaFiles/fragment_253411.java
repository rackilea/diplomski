public class CustomerTest {
static int numItem = 0;
public static void main(String[] args) {
    Customer[] customers = new Customer[10];
    Scanner myScanner = new Scanner(System.in);

    readCustomer(myScanner, customers); //not sure about this calling
    readNameAmount(myScanner, customers); ////not sure about this calling
}
public static void readCustomer(Scanner myScanner, Customer[] input) {
    boolean streamEnded = false;

    while (!streamEnded && myScanner.hasNext()) {
        String name = myScanner.nextLine();
        String id = myScanner.nextLine();
        if (name.length() == 0 && id.length() == 0) {
            streamEnded = true;
        } 
        else {
            input[numItem].getName();
            input[numItem].getId(); //error
        }
        numItem++;
        Customer customerTest = new Customer(name, id);
    }
}
public static void readNameAmount(Scanner myScanner, Customer[] input) {
    while (myScanner.hasNext()) {

        String id = myScanner.nextLine();
        Customer cust = new Customer();
        double amount = myScanner.nextDouble();
        int i = 0;
        boolean found = false;

        while (i < numItem && !found) { //error

            if (input[i].equals(id)) { //error
                cust.changeBalance(amount);//error
            }
            found = true;
            i++;
        }
    }
} 
public static void print(Customer[] input, int numItem) {

    for (int i = 0; i < numItem; i++) {

        System.out.println(input[i].toString()); //error
    }
}
}