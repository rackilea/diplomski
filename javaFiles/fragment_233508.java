insertSchool = con.prepareStatement(INSERT_SCHOOL);
    insertSchool.setString(1, newSchool.getName());
    insertSchool.setString(2, newSchool.getState());
    insertSchool.setString(3, newSchool.getCity());
    insertSchool.setInt(4, newSchool.getRank());
    insertSchool.executeUpdate();