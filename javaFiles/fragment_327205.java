public QueueLine getCustomer(int index) {
    synchronized (Customers) {        
        while (Customers.isEmpty()) {
            Customers.wait();
        } 
        return Customers.elementAt(index);
    }
}