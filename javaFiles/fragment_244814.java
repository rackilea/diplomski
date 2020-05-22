public class MyItem implements ResourceAware {

    private Resource resource;

    public String getId() {
        return createIdFromResource(resource);
    }

    private String createIdFromResource(final Resource resource) {
        // create your ID here
        return resource.getFilename();
    }

    @Override
    public void setResource(final Resource resource) {
        this.resource = resource;
    }
}