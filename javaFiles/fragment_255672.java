public class TypesafePropertySourceFactory implements PropertySourceFactory {

    @Override
    public PropertySource<?> createPropertySource(String name, EncodedResource resource) throws IOException {
        Config config = ConfigFactory.load(resource.getResource().getFilename()).resolve();

        String safeName = name == null ? "typeSafe" : name;
        return new TypesafeConfigPropertySource(safeName, config);
    }

}