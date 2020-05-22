public final class Dummy extends AbstractDummy
{   
  /**
   * Constructor meant to be used for test code.
   * @param scope test-specific "globals"
   * @param value some user-supplied value
   */
  public Dummy(SingletonScope scope, int value)
  {
    super(scope, value);
  }
}