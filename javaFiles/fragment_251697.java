@ManagedBean(name="customer")
public class Customer implements Serializable {
    private List<Customer> custormerList= new ArrayList<Customer>();

    public void setCustomerList(List<Customer> cust){
       this.customerList = cust;
    }
    public List<Customer> getCustomerList(){
        return customerBo.findAllCustomer();
    }
}