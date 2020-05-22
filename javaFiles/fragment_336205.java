import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

public class FooResultSetIterator implements Iterator<Foo>
{
  private final ResultSet resultSet;
  private boolean hasNext;

  FooResultSetIterator(final ResultSet resultSet, final int fetchSize) throws SQLException
  {
    this.resultSet = resultSet;
    this.resultSet.setFetchSize(fetchSize);
    this.hasNext = resultSet.next();
  }

  @Override
  public boolean hasNext()
  {
    return hasNext;
  }

  @Override
  public Foo next()
  {
    final Foo foo = new Foo(resultSet);
    try
    {
      this.hasNext = resultSet.next();
    }
    catch (final SQLException e)
    {
      throw new RuntimeException(e);
    }
    return foo;
  }

  @Override
  public void remove()
  {
    throw new UnsupportedOperationException("Cannot remove items from a ResultSetIterator");
  }

}

class Foo
{
  public Foo(ResultSet resultSet)
  {
    // TODO Auto-generated constructor stub
  }
}