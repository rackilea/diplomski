import static java.util.Comparator.*;
....
Comparator<Customer> comparator = 
    comparing(Customer::getCustNumber, nullsLast(naturalOrder()))
    .thenComparing(Customer::getQueueId)
    .thenComparing(Customer::getCustName);