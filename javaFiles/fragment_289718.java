public class Agent
{
    string _strName;
    bool _bIsBusy = false;//
    public bool IsBusy { get { return _bIsBusy; } }

    Customer _Customer;
    public Agent(string strName)
    {
        _strName = strName;
    }

    public void HandleCustomer(Customer theCustomer)
    {
        _Customer = theCustomer;
        _bIsBusy = true;//Busy as long as the window is open.

        //You might need something that doesnt block;
        Thread.Sleep(5 * 1000); //Wait for time to simulate that agent is talking to customer

        RemoveCustomer();//Done with the customer.
    }

    private void RemoveCustomer()
    {
        _Customer = null;
        _bIsBusy = false;
    }
}