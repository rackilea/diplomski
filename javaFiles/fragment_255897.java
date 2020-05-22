import java.security.Provider;
import java.security.Security;

public class WindowsSecureRandom extends Provider {
    private static final String MSCAPI = "sun.security.mscapi.PRNG";

    private WindowsSecureRandom() {
        super("WindowsSecureRandom Provider", 1.0, null);
        putService(new Service(this, "SecureRandom", "Windows-PRNG", MSCAPI, null, null));
    }

    public static void register() {
        if (System.getProperty("os.name").contains("Windows")) {
            try {
                Class.forName(MSCAPI);
                Security.insertProviderAt(new WindowsSecureRandom(), 1);
            } catch (ClassNotFoundException e) {
                // Fallback to default implementation
            }
        }
    }
}