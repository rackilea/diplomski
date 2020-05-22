Connection con = getConnection();
    PreparedStatement posted= con.prepareStatement("INSERT INTO studinfo (studName, studNum, studYrLvl, studKors, studGender) VALUES (?,?,?,?,?)");

    int y=1;
    posted.setString(y++, studName);
    posted.setString(y++, studNum);
    posted.setString(y++, studYrLvl);
    posted.setString(y++, studKors);
    posted.setString(y++, studGender);

    posted.executeUpdate(); // Manipulate or Update table
    posted.close();