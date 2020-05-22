private boolean isNeighbor(ArrayList<Customer> collection, Customer node,DirectedSparseGraph<Customer, Transaction> network) throws SQLException {
        HashMap<String, Customer> realNodes = new HashMap<String, Customer>();
        Collection<Customer> nodes=network.getVertices();

        for (Customer n: nodes) {
            realNodes.put(n.getName(), n);
        }

        Customer acctualNode = realNodes.get(node.getName());
        for(Customer customer:collection){
            Customer actualCustomer = realNodes.get(customer.getName());
            if(network.isSuccessor(actualCustomer, acctualNode)) {
                return true;
            }
        }
        return false;
    }