import org.opensaml.DefaultBootstrap;
import org.opensaml.xml.ConfigurationException;

try {
    DefaultBootstrap.bootstrap();
}
catch (ConfigurationException ce) {
}