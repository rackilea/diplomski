// ...
 PreparedStatement ps1, ps2;
 ps1 = con.prepareStatement("delete from hib.personrole where personid = ?");
 ps2 = con.prepareStatement("delete from hib.persongroup where personid = ?");

 ps1.setString(1, userID);
 ps2.setString(1, userID);

 ps1.execute();
 ps2.execute();
 // ...