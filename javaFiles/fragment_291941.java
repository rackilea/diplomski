public interface NFCService {

    boolean isAvailable();

    boolean isEnabled();

    StringProperty tagIdProperty();

    // other methods

}