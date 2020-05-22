public class ResourcePathFactoryBean extends AbstractFactoryBean<String> {

    private Resource resource;

    @Required
    public void setResource(Resource resource) {
        this.resource = resource;
    }

    @Override
    protected String createInstance() throws Exception {
        return resource.getFile().getAbsolutePath();
    }

    @Override
    public Class<?> getObjectType() {
        return String.class;
    }
}