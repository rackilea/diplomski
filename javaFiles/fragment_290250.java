import java.util.Map;
import org.hibernate.c3p0.internal.C3P0ConnectionProvider;
import org.hibernate.cfg.AvailableSettings;
import org.jasypt.encryption.pbe.PBEStringEncryptor;
import org.jasypt.exceptions.EncryptionInitializationException;
import org.jasypt.hibernate4.connectionprovider.ParameterNaming;
import org.jasypt.hibernate4.encryptor.HibernatePBEEncryptorRegistry;
import org.jasypt.properties.PropertyValueEncryptionUtils;

public final class EncryptedPasswordC3P0ConnectionProvider extends C3P0ConnectionProvider {

    public EncryptedPasswordC3P0ConnectionProvider() {
        // call the constructor of the super class
        super();
    }

    // configure method get a Map object (old hibernate version got a Properties object)
    public void configure(Map props) {
        final String encryptorRegisteredName =
        (String) props.get(ParameterNaming.ENCRYPTOR_REGISTERED_NAME);

        final HibernatePBEEncryptorRegistry encryptorRegistry =
        HibernatePBEEncryptorRegistry.getInstance();
        final PBEStringEncryptor encryptor = 
        encryptorRegistry.getPBEStringEncryptor(encryptorRegisteredName);

        // encryptor should never be null
        if (encryptor == null) {
            throw new EncryptionInitializationException(
               "No string encryptor registered for hibernate " +
               "with name \"" + encryptorRegisteredName + "\"");
        }

        // Get the original values from your hibernate config file
        final String user = (String) props.get(AvailableSettings.USER);
        final String password = (String) props.get(AvailableSettings.PASS);
        final String driver = (String) props.get(AvailableSettings.DRIVER);
        final String url = (String) props.get(AvailableSettings.URL);

        // Perform decryption operations as needed and store the new values
        if (PropertyValueEncryptionUtils.isEncryptedValue(driver)) {
            props.put(
              AvailableSettings.DRIVER, 
              PropertyValueEncryptionUtils.decrypt(driver, encryptor));
        }
        if (PropertyValueEncryptionUtils.isEncryptedValue(url)) {
            props.put(
              AvailableSettings.URL, 
              PropertyValueEncryptionUtils.decrypt(url, encryptor));
        }
        if (PropertyValueEncryptionUtils.isEncryptedValue(user)) {
            props.put(
              AvailableSettings.USER, 
              PropertyValueEncryptionUtils.decrypt(user, encryptor));
        }
        if (PropertyValueEncryptionUtils.isEncryptedValue(password)) {
            props.put(
              AvailableSettings.PASS, 
              PropertyValueEncryptionUtils.decrypt(password, encryptor));
        }

        // Let Hibernate framework do the rest
        super.configure(props);
        }  
    }
    ... // your getters, setters, ...
}