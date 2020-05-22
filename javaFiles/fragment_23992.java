public class Customer2 implements Comparable<Customer2>{
    private String firstName;
    private String lastName;
    private int accountBalance;
    public int total=0;
    public Customer2(String fName, String lName, int balance){
        firstName = fName;
        lastName = lName;
        accountBalance = balance;
    }
    public void setFirstName(String newFirstName){
        firstName = newFirstName;
        }
        public void setLastName(String newLastName){
        lastName = newLastName;
        }
    public String getFirstName() {

    return firstName;

    }

    public String getLastName() {

    return lastName;

    }



    public double getAccountBalance() {

    return accountBalance;

    }
    public void withdraw(int amount){
        total=accountBalance-amount;
        accountBalance=total;

    }
    public void deposit(int amount){
        total=accountBalance+amount;
        accountBalance=total;
    }



    public void menu(){

            System.out.println("a  Show all records");
            System.out.println("r  Remove the current record");
            System.out.println("f  Change the first name in the current record");
            System.out.println("l  Change the last name in the current record");
            System.out.println("n  Add a new record");
            System.out.println("d  Add a deposit to the current record");
            System.out.println("w  Make a withdrawal from the current record");
            System.out.println("s Select a record from the record list to become the current record");
        }

    @Override
    public int compareTo(Customer2 o) {
        // TODO Auto-generated method stub
        return o.lastName.compareTo(lastName);

    }
    }