public class Constants {
// Properties (user configurable)
public static final String DB_URL = Configurations.getInstance().getProperty(Properties.DB_URL);
public static final String DB_DRIVER = Configurations.getInstance().getProperty(Properties.DB_DRIVER );

// Constants (not user configurable)
public static final String PATH_CONFFILE = "config/config.properties";
public static final int MYCONSTANT_ONE = 1;
}