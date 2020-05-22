String query = ("INSERT INTO tblusers (first_name, middle_initial, last_name, username, password, privilege)"
    + " VALUES (?,?,?,?,?,?)");
PreparedStatement ps1 = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
ps1.setString(1, txtFn.getText());
ps1.setString(2, txtMi.getText());
ps1.setString(3, txtLn.getText());
ps1.setString(4, txtUser.getText());
ps1.setString(5, txtPass.getText());
ps1.setString(6, "student");
ps1.executeUpdate();
ResultSet rs = ps1.getGeneratedKeys();
Integer result =- 1;

if (rs.next()) {
    result = rs.getInt(1);
}

String query2 = "INSERT INTO tblcourseinfo (user_id, course_id, school_id) VALUES (?,?,?)";
PreparedStatement ps2 = con.prepareStatement(query2);
ps2.setInt(1, result);
ps2.setInt(2, cmbCourse.getId());
ps2.setInt(3, cmbSchool.getId());
ps2.executeUpdate();