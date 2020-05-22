public class YamlPropertyLoaderFactory extends DefaultPropertySourceFactory {

    @Override
    public PropertySource<?> createPropertySource(String name, EncodedResource resource) throws IOException {
        if (resource == null){
            return super.createPropertySource(name, resource);
        }
        List<PropertySource<?>> sources = new YamlPropertySourceLoader().load(resource.getResource().getFilename(), resource.getResource());
        for (PropertySource<?> checkSource : sources) {
            if (checkSource.containsProperty("spring.profiles.active")) {
                String activeProfile = (String) checkSource.getProperty("spring.profiles.active");
                for (PropertySource<?> source : sources) {
                    if (activeProfile.trim().equals(source.getProperty("spring.profiles"))) {
                        return source; 
                    }
                }
            }
        }
        return sources.get(0);
    }

}