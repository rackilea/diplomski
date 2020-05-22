import org.apache.avalon.framework.configuration.Configuration;
import org.apache.avalon.framework.configuration.DefaultConfigurationBuilder;

...

DefaultConfigurationBuilder cfgBuilder = new DefaultConfigurationBuilder();
Configuration cfg = cfgBuilder.buildFromFile(new File("conf/conf.xml"));
FopFactoryBuilder fopFactoryBuilder = new FopFactoryBuilder(new File(".").toURI()).setConfiguration(cfg);
FopFactory fopFactory = fopFactoryBuilder.build();