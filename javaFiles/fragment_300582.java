public interface ConfigurationMapFactory<K, V> {
    public Map<K, V> createMap();
}

public class Configuration <K, V> {
    public Map<K, V> fields;

    public Configuration(ConfigurationMapFactory<K, V> mapFactory) {
        this.fields = mapFactory.createMap();
    }
}