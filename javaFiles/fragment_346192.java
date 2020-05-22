PreparedStatement stmt=con.prepareStatement("UPDATE item SET itemname=? WHERE numb=?");  
stmt.setString(1, newitm);  
stmt.setInt(2, no);

int i = stmt.executeUpdate();  
System.out.println(i + " records updated");