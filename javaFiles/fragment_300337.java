public class MyResultSet implements ResultSet {

  // Delegate most implementations to the underlying database result set:
  private final ResultSet delegate;
  public MyResultSet(ResultSet delegate) {
    this.delegate = delegate;
  }

  @Override
  public int getInt(int index) throws SQLException {
    return delegate.getInt(index);
  }

  // [... more delegate methods ...]

  // Add custom methods
  public void setData(Object someValue) { ... }
  public Object getData() { ... }
}