package com.mycompany.key;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mycompany.dao.CustomerDao;
import com.mycompany.model.Customer;

public class CustomerManager {

    //private static Map<String, String> clientKeyToCustomerId = 
    // new HashMap<String, String>();
    private volatile static Map<String, String> clientKeyToCustomerId = 
               new HashMap<String, String>();

    public static void loadCustomers() {
        List<Customer> allCustomers = new CustomerDao().loadAll();
        Map<String, String> newClientKeyToCustomerId = new HashMap<String, String>();
        for (Customer customer : allCustomers) {
            newClientKeyToCustomerId.put(customer.getActiveKey1(),
                    customer.getCustomerId());
            newClientKeyToCustomerId.put(customer.getActiveKey2(),
                    customer.getCustomerId());
        }
        clientKeyToCustomerId = newClientKeyToCustomerId;
    }

    public static String getCustomerIdByClientKey(String pClientKey) {
        return clientKeyToCustomerId.get(pClientKey);
    }

}