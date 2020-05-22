import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class DifferentCollections {

    public static void main(String[] args) {


        List<Customer> customers = new ArrayList<>(Arrays.asList(new Customer(1), new Customer(2), new Customer(10)));
        List<License> licenses = new ArrayList<>(Arrays.asList(new License(1), new License(2), new License(30)));

        List<Customer> filteredCustomers = customers.stream().
                filter(c -> customerIdFoundInLicensesList(c, licenses)).
                collect(Collectors.toList());

        System.out.println(filteredCustomers);
    }

    private static boolean customerIdFoundInLicensesList(Customer customer, List<License> licenses) {
        return licenses.stream().
                filter(l -> l.getId().equals(customer.getId())).
                findAny().
                isPresent();
    }
}

class Customer {
    Integer id;

    public Customer(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + '}';
    }
}

class License {
    Integer id;

    public License(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "License{" + "id=" + id + '}';
    }
}