/**
 * Objects providing an internal API implement this interface
 */
public interface Adapter {

  /**
   * Dynamically expose an (publicly unknown) internal API. 
   */
  <T> T internalAPI(Class<T> internalType) throws ClassCastException;
}