public class CustomerServiceBench
{
    Queue<Customer> queCustomers = new Queue<Customer>();
    List<Agent> lstAgents = new List<Agent>();
    Thread thdService;

    public CustomerServiceBench()
    {
        //Something along these lines.
        thdService = new Thread(delegate() { WaitAndAddCustomerIfAgentIsAvailable(); });

    }

    private void AddCustomer()
    {
        //Add a dummy customer.
        Random r = new Random(1231);
        queCustomers.Enqueue(new Customer("Customer" + r.Next().ToString()));

        Thread.Sleep(5 * 1000); //SpinWait.Once()...

    }

    private void WaitAndAddCustomerIfAgentIsAvailable()
    {
        //Thread1 to manage the 

    }
}