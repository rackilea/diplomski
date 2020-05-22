/**
 * This class is the base class for all QueryParts.
 * It is package private and thus doesn't expose anything
 */
abstract class AbstractQueryPart implements QueryPartInternal {
  // [...]

  /**
   * For other package private implementation methods
   */
  @Override
  public final <T> internalAPI(Class<T> internalType) {
    return internalType.cast(this);
  }

  /**
   * Convenience method for subclasses heavily using the
   * internal API
   */
  protected final QueryPartInternal internal(QueryPart part) {
    return part.internalAPI(QueryPartInternal.class);
  }
  // [...]
}