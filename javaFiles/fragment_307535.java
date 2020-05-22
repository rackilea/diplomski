public Class1<T>
{
  public Object getColumn(DataSource ds)
  {
    Object o        = null;
    Connection con  = null;

    try
    {
      con           = ds.getConnection();
      Statement st  = con.createStatement();
      ResultSet rs  = st.executeQuery("select 1 from dual");
      rs.next();
      Object o      = rs.getObject(1);
      rs.close();
      st.close();
    }
    finally
    {
      if (con != null) { con.close(); }
    }

    return o;
  }
}

Class1Integer extends Class1<Integer>
{
  public Integer getIntegerColumn()
  {
    Object o  = getColumn(datasource);
    Integer i = new Integer(o);
    return i;
  }
}