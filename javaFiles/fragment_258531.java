public CustomerAccount findCustomer(String regNum) throws CustomerNotFoundException
{
    for (int i=0; i < accounts.size(); i++)
    {
        if(regNum.equals(accounts.get(i).getCustomerVehicle().getRegistration()))
        {
            return accounts.get(i);
        }
    }
    throw new CustomerNotFoundException();
}