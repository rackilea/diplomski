public class Singleton
{
  public static Singleton getInstance() {
    return SingletonHolder.instance;
  }

  private Singleton() {}

  private static final class SingletonHolder {
    static final Singleton instance = new Singleton();    
  }
}