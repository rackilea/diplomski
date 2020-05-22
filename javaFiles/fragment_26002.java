ps = pooledConn.prepareStatement("SELECT IDENT_CURRENT('all_app_users')");
rs = ps.executeQuery();
rs.next(); // <<== Add this line
allAppUserId = (long)rs.getInt(0);
rs.close();

ps = pooledConn.prepareStatement("INSERT INTO myapp_users ( all_app_user_id, myapp_user_stage ) VALUES( ?, ? )");
ps.setInt(1, Ints.checkedCast(allAppUserId));
ps.setInt(2, 5);
ps.execute();
ps.close();

ps = pooledConn.prepareStatement("SELECT IDENT_CURRENT('myapp_users')");
rs = ps.executeQuery();
rs.next(); // <<== Add this line
myAppId = (long)rs.getInt(0);