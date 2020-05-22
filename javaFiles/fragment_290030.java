public class SystemPropertiesReader{

    private Collection<Resource> resources;

    public void setResources(final Collection<Resource> resources){
        this.resources = resources;
    }

    public void setResource(final Resource resource){
        resources = Collections.singleton(resource);
    }

    @PostConstruct
    public void applyProperties() throws Exception{
        final Properties systemProperties = System.getProperties();
        for(final Resource resource : resources){
            final InputStream inputStream = resource.getInputStream();
            try{
                systemProperties.load(inputStream);
            } finally{
                // Guava
                Closeables.closeQuietly(inputStream);
            }
        }
    }

}