ResultSet rs = stmt.executeQuery(query);
  if(! rs.next()) {
    return;
  }
  //read first reacord

   if(! rs.next()) {
    return;
  }
  //read second reacord