@GET
public MyResultStream getData()
{
  ResultSet rs = queryDatabase();
  return new MyResultStream(rs);
}