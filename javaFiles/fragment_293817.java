private boolean isNeighbor(ArrayList<Customer> collection, Customer node,DirectedSparseGraph<Customer, Transaction> network) throws SQLException {
        for(Customer customer:collection){
            //if(network.isSuccessor(customer, node)) { 
            if(isSuccessor(network, customer, node)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSuccessor(DirectedSparseGraph<Customer, Transaction> network, Customer customer, Customer node) {
        Customer mockNode = node;
        Customer mockCustomer = customer;
        // If you can't redefine equals method for Customer object then you need to create a mock object mockNode.equals(node) == true && mockCustomer.equals(customer)
        Collection<Customer> successors = network.getSuccessors(mockNode);
        return successors != null && successors.indexOf(mockCustomer) != -1;
    }