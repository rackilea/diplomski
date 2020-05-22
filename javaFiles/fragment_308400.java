for (CustomerDetails nextCustomer : customers){
    if (givenID == nextCustomer.getCustomerID()){
        return nextCustomer;
    }
}
throw new CustomerNotFoundException();