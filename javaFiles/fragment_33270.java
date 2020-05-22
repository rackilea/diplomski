public List resultSetToArrayList(ResultSet rs) throws SQLException{
  ResultSetMetaData md = rs.getMetaData();
  int columns = md.getColumnCount();
  ArrayList list = new ArrayList(50);
  while (rs.next()){
     HashMap row = new HashMap(columns);
     for(int i=1; i<=columns; ++i){           
      row.put(md.getColumnName(i),rs.getObject(i));
     }
      list.add(row);
  }

 return list;
}