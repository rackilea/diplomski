class StateCityComparator implements Comparator<Customer> {

    /**
     * Compare method that compares Customers by state and city
     * @param first, second which are the numbers of the customer which needs to be compared
     */
    @Override
    public int compare(Customer first, Customer second){

        // Getting the state
        String fir = first.getState();
        String sec = second.getState();
        int state = fir.compareTo(sec);
        int city =  first.getCity().compareTo(second.getCity());

        // Compare the state, and the city if the states are equal
        return (state == 0)? city : state;

    }// End of compareStateCity

} //