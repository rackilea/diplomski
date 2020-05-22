public class ServiceModel {
    private String version;
    private Map<String, ContainerModel> containers;
    // Other fields here...

    public void setContainers(Map<String, ContainerModel> containers) {
        this.containers = containers;
    }

    public Map<String, ContainerModel> getContainers() {
        return containers;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    // Other setters/getters here...
}