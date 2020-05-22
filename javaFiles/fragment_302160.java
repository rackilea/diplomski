public interface RequestService<T extends Transaction> {
    public String getRequest(T transaction);
}

public class ESPRequestService implements RequestService<ESPTransaction> {
    @Override
    public String getRequest(ESPTransaction espTransaction) {
        StringBuffer buff = new StringBuffer(espTransaction.someMethodThatDoesntExistInParentClass());
        return buff.toString();
    }
}