@Inject
private ResourceLoader resourceLoader;

public void someMethod() {
    Resource resource = resourceLoader.getResource("file:my-file.xml");
    InputStream is = null;
    try {
        is = resource.getInputStream();
        // do work
        ....
    } finally {
        IOUtils.closeQuetly(is);
    }
}