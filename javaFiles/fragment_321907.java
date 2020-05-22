@Entity(noClassnameStored = true)
public class AutoIncrementEntity {

  @Id
  protected String key;

  protected Long value = 1L;

  protected AutoIncrementEntity() {
    super();
  }

  /**
   * Set the key name — class or class with some other attribute(s).
   */
  public AutoIncrementEntity(final String key) {
    this.key = key;
  }

  /**
   * Set the key name and initialize the value so it won't start at 1.
   */
  public AutoIncrementEntity(final String key, final Long startValue) {
    this(key);
    value = startValue;
  }

  public Long getValue() {
    return value;
  }
}