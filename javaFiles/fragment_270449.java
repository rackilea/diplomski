public class ClientSearchComparator implements Comparator<ClientSearch> {
    @Override
    public int compare(ClientSearch c1, ClientSearch c2) {
        if (c1.custNum != null && c2.custNum != null) {
            if (c1.custNum != c2.custNum) {
                return c1.custNum.compareTo(c2.custNum);
            }
            return c1.custName.compareTo(c2.custName);
        } else if (c1.custNum == null && c2.custNum == null) {
            if (c1.queueId != c2.queueId) {
                return c1.queueId .compareTo(c2.queueId);
            }
            return c1.custName.compareTo(c2.custName);
        } else if (c1.custNum == null) { // c1 null && c2 not null
            return 1;
        } else {  // c1 not null && c2 null
            return -1;
        }
    }