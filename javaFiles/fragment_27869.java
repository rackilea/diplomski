@Configuration
@PropertySource(name = "someName", value = "classpath:foo.yaml", factory = YamlPropertySourceFactory.class)
public class MyConfig {
}


import org.springframework.boot.env.YamlPropertySourceLoader;
public class YamlPropertySourceFactory implements PropertySourceFactory {

    @Override
    public PropertySource<?> createPropertySource(String name, EncodedResource resource) throws IOException {
        final List<PropertySource<?>> load = new YamlPropertySourceLoader().load(name, resource.getResource());
        return load.get(0);
    }
}