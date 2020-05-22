public interface Configuration {
    public Continent getContinent(); //For fixed set of values use enum
    public Integer getPoolSize(); //If the config can take any value then use the corresponding data type directly
    public String getDefaultLabel();
}

public enum Continent {
    ANTARTICA, AFRICA, ASIA, AUSTRALIA, EUROPE, NORTH_AMERICA, SOUTH_AMERICA;
}

public class ConfigurationBuilder {

    private DefaultConfiguration configurationInstance;

    private class DefaultConfiguration implements Configuration {

        //Ideally the below values should be read from a property file, instead of hard coding it here.
        private Integer poolSize = Integer.valueOf(50);
        private String defaultLabel = "DEFAULT";
        private Continent continent = Continent.ASIA;

        @Override
        public Continent getContinent() {
            return continent;
        }

        @Override
        public Integer getPoolSize() {
            return poolSize;
        }

        @Override
        public String getDefaultLabel() {
            return defaultLabel;
        }
    }

    public ConfigurationBuilder withContinent(Continent continent) {
        this.configurationInstance.continent = continent;
        return this;
    }

    public ConfigurationBuilder withPoolSize(Integer poolSize) {
        this.configurationInstance.poolSize = poolSize;
        return this;
    }

    public ConfigurationBuilder withDefaultLabel(String defaultLabel) {
        this.configurationInstance.defaultLabel = defaultLabel;
        return this;
    }

    public Configuration build() {
        return this.configurationInstance;
    }

    public ConfigurationBuilder() {
        this.configurationInstance = new DefaultConfiguration();
    }

    public static Configuration buildDefaultConfiguration() {
        return new ConfigurationBuilder().build();
    }
}

public class Library {
    private Configuration configuration;
    public void init(Configuration configuration) {
        this.configuration = configuration;
    }
    public void init() {
        this.configuration = ConfigurationBuilder.buildDefaultConfiguration();
    }
    private Library(Configuration config) {
        this.init(config);
    }
    private Library() {
        this.init();
    }

    /**
     * Library is not singleton here.
     * 
     */
    public static Library getInstance(Configuration configuration) {
        return new Library(configuration);
    }
    public static Library getInstance() {
        return new Library();
    }
}

public class Client {
    public static void main(String args[]) {
        Configuration config = new ConfigurationBuilder()
                .withContinent(Continent.AFRICA)
                .withPoolSize(20)
                .withDefaultLabel("Label")
                .build();
        Library lib = Library.getInstance();
        lib.init(config);
    }
}