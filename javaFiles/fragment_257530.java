package cloud;

public class Instance {
    private String instanceId;
    private String customer;
    private Host host; // this will be a reference to the related host object

    public Instance(String instanceId, String customer, Host host) {
        this.instanceId = instanceId;
        this.customer = customer;
        this.host = host;
    }

    // valid getters and setters follow...

}