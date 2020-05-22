import java.util.Scanner;

public class ReadSortCustomerData {

    public static void main(String [] args) {
    int numberOfCustomers;
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the total number of customers: ");
    numberOfCustomers = input.nextInt();

    CustomerData [] customer = new CustomerData[numberOfCustomers];

    for(int countCustomer=0 ; countCustomer < numberOfCustomers; countCustomer++) {

        System.out.println("Enter the name of the"+(countCustomer+1)+"customer");
        customer[countCustomer].setName(input.next());
        System.out.println("Enter the age of the"+(countCustomer+1)+"customer");
        customer[countCustomer].setAge(input.nextInt());
        System.out.println("Enter the gender of the"+(countCustomer+1)+"customer");
        customer[countCustomer].setGender(input.next());
        System.out.println("Enter the address of the"+(countCustomer+1)+"customer");
        customer[countCustomer].setGender(input.next());
    }


  }

    public CustomerData[] sortCustomerData(CustomerData[] customers) {

        for (int i=0;i<customers.length;i++) {

            for(int j=i+1;j<customers.length;j++) {

                if(ageCompare(customers[i], customers[j])==1) {
                    CustomerData tempCustomer = new CustomerData();
                    tempCustomer = customers[i];
                    customers[i] = customers[j];
                    customers[j] = tempCustomer;
                }

                }
            }

        return customers;
    }

    public int ageCompare(CustomerData a, CustomerData b)
    {
        return a.getAge() < b.getAge() ? -1 : a.getAge() == b.getAge() ? 0 : 1;
    }
}




import java.util.Comparator;
import java.util.Scanner;


public class CustomerData {

    private String name;
    private int age;
    private String address;
    private String gender;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

}