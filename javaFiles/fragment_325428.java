public class CustomerData {
    private String id;
    private String version;
    // other customer fields
    private List<Order> orders;
}

public class Order {
    private String orderId;
    private String orderType;
    // other order fields
}

CustomerData data = ...;
Location location = new Location(new Namespace(BUCKET_TYPE, BUCKET_NAME), key);
StoreValue storeCommand = new StoreValue.Builder(data).withLocation(location).build();
riakClient.execute(storeCommand);