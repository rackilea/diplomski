class StateCityComparator implements Comparator<Customer> {

    /**
     * Compare method that compares Customers by state and city
     * @param first, second which are the numbers of the customer which needs to be compared
     */
    @Override
    public int compare(Customer first, Customer second){
        int state = first.getState().compareTo(second.getState());
        return (state != 0)? state : first.getCity().compareTo(second.getCity());

    }// End of compareStateCity

} //