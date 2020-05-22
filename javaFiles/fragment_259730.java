ResultSet rs = ps.executeQuery();
Messaging m= new Messaging();
Users u= new Users();
MessageBox mb = new MessageBox();  //<-------

...
m.setTimestamp(rs.getString(4));
m.setMsgrecipient(rs.getInt(5));
m.setUsers_userid(rs.getInt(6));
u.setFname(rs.getString(7));
u.setLname(rs.getString(8));
mb.setMessage(m);  //<-----------
mb.setUsers(u);  //<----------
...
return mb;  //<------------