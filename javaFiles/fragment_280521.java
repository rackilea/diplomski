public abstract class MyBase {
  /**
   * @param id The id that will be used for...
   * @param good ignored by most implementations
   * @return The string for id
   */
  protected abstract String myFunc(Long id, boolean good);
}

class MyImpl extends MyBase {

  /**
   * {@inheritDoc}
   * @param good is used differently by this implementation
   */
  @Override
  protected String myFunc(Long id, boolean good) { .. }
}