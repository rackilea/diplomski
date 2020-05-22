try {
        PreparedStatement stmt = con.prepareStatement("INSERT into emailacc(fname,lname,uname,mail,passwd,passwd2,date,month,year) values(?,?,?,?,?,?,?,?,?)");
        stmt.setString(1,fname);
        stmt.setString(2,lname);
        stmt.setString(3,uname);
        stmt.setString(4,mail);
        stmt.setString(5,passwd);
        stmt.setString(6,passwd2);
        stmt.setDate(7,date); //you need convert your date to java.sql.Date if 'date' field of database is of type date. If not setString is fine
        stmt.setInt(8,selectMonth);
        stmt.setInt(9,year);
        stmt.executeUpdate();
        out.println("<h3><font color='green'>Information Added Successfully.</font><br> You Are a registered User now.</h3><br>");
    } catch (Exception e) {
        con.rollback();
        out.println("Exception caught : " + e);
    } finally {
        if (con != null) {
            try {
                con.close();
            } catch(SQLException ex){
                //DO NOTHING
            }
        }
    }