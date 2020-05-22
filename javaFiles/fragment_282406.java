public final class Dummy extends AbstractDummy
{   
  /**
   * Constructor meant to be used by end-users.
   * @param value some user-supplied value
   */
  public Dummy(int value)
  {
    super(MainSingletonScope.INSTANCE, value);
  }
}