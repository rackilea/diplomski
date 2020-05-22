public interface KeyRetriever<T> {
    public Object getKey(T obj);
}

public class CustomerTypeKeyRetriever implements KeyRetriever<Customer> {

    @Override
    public String getKey(Customer obj) {
        // TODO Auto-generated method stub
        return null;
    }

}