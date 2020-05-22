PreparedStatement ps = 
  conn.prepareStatement("select * from table_nm 
                         where Date1 BETWEEN ? AND ? ");

ps.setDate( 1, startDate );
ps.setDate( 2, endDate );