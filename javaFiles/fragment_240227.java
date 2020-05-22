PreparedStatement st = (PreparedStatement) con.prepareStatement("insert into temp values(?)");
    i=0;
   while(rs.next())
    {
      st.setString(1,anArray[i]);
      st.executeUpdate();
      i++;
    }