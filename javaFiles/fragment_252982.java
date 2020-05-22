public class ServiceGroup {

    private String name;
    private List<Service> services;

    public ServiceGroup(String name) {
        this.name = name;
        this.services = new ArrayList<>();
    }

    public List<Service> getServices() {
        return services;
    }
}