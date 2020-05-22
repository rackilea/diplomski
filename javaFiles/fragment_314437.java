public class UploadedResourceHandler extends ResourceHandlerWrapper {

    private ResourceHandler wrapped;

    public MyResourceHandler(ResourceHandler wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public ResourceHandler getWrapped() {
        return this.wrapped;
    }

    @Override
    public Resource createResource(String resourceName, String libraryName) {
        if ("uploads".equals(libraryName)) {
            return new YourCustomUploadedResourceImpl(resourceName);
        } else {
            return super.createResource(resourceName, libraryName);
        }
    }

}