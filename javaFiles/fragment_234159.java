public class YamlPropertyLoaderFactory extends DefaultPropertySourceFactory {
    @Override
    public PropertySource<?> createPropertySource(String name, EncodedResource resource) throws IOException {
        if (resource == null){
            return super.createPropertySource(name, resource);
        }

        return new YamlPropertySourceLoader().load(resource.getResource().getFilename(), resource.getResource(), null);
    }
}