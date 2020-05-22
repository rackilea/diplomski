Connection c= null;
PreparedStatement ps= null;

c = setTheDBConnection(); //just for example

ps = c.preparedStatement("INSERT INTO `order` (Odate,Ddate,ShippingAddr,Email) VALUES (?,?,?,?)");

ps.setString(1, o.getOdate());
ps.setString(2, o.getDdate());
ps.setString(3, o.getShippingAddr());
ps.setString(4, Email);

ps.executeUpdate();