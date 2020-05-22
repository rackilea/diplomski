package blog.immutable.adpater;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import blog.immutable.Customer;

public class CustomerAdapter extends XmlAdapter<AdaptedCustomer, Customer> {

    @Override
    public Customer unmarshal(AdaptedCustomer adaptedCustomer) throws Exception {
        return new Customer(adaptedCustomer.getName(), adaptedCustomer.getAddress());
    }

    @Override
    public AdaptedCustomer marshal(Customer customer) throws Exception {
        AdaptedCustomer adaptedCustomer = new AdaptedCustomer();
        adaptedCustomer.setName(customer.getName());
        adaptedCustomer.setAddress(customer.getAddress());
        return adaptedCustomer;
    }

}