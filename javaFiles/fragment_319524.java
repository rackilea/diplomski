while (rs.next()) { //rs now has all the employee
      String empvalue = rs.getString("empno");
        pst = con.prepareStatement("insert into leaves(empno,casual,annual,medical,year)values(?,?,?,?,?)");
        pst.setString(1,empvalue); // employee no how to give 
        pst.setString(2, cas);
        pst.setString(3, anu);
        pst.setString(4, med);
        pst.setString(5, year);         
        pst.executeUpdate();
    }