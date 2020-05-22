public abstract class ComponentLocator {
  protected static ComponentLocator myInstance;

  protected abstract <T> T locateComponent(Class<T> componentClass, String language);

  public static <T> T getComponent(Class<T> componentClass, String language) {
    return myInstance.locateComponent(componentClass, language);
  }
}