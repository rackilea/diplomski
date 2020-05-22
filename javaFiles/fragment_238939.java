String sql = "select * from NM_PROPERTIES_LOADER";
 ResultSet rs = stmt.executeQuery(sql);

 while(rs.next()) {
     PropertyData reader = new PropertyData();
     String name = rs.getString("prop_name");
     String value = rs.getString("prop_value");
     reader.setPropName(name);
     reader.setPropValue(value);

     // other setter calls..  

     prop.add(reader);
 }