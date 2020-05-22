public class MyResultSet implements ResultSet {
  // [...]

  @Override
  public int getInt(int index) throws SQLException {
    if (index == 3) {
      return 42;
    } else {
      return delegate.getInt(index);
    }
  }
}