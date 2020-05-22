public class ClientSearchComparator implements Comparator<ClientSearch> {
    private static Comparator<ClientSearch> custNumberComparator = 
        Comparator.comparing(ClientSearch::getCustNumber)
                .thenComparing(ClientSearch::getCustName);
    private static Comparator<ClientSearch> queueIdComparator = 
        Comparator.comparing(ClientSearch::getQueueId)
                .thenComparing(ClientSearch::getCustName);
    @Override
    public int compare(ClientSearch c1, ClientSearch c2) {
        if (c1.getCustNumber() != null && c2.getCustNumber() != null) {
            return custIdComparator.compare(c1, c2);
        } else if (c1.getCustNumber() == null && c2.getCustNumber() == null) {
            return queueIdComparator.compare(c1, c2);
        } else if (c1.getCustNumber() != null && c2.getCustNumber() == null) {
            return -1;
        } else {  // (c1.getCustNumber() == null && c2.getCustNumber() != null) 
            return 1;
        }
    }
}