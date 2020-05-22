Statement stmt = conn.createStatement();
            String query = "INSERT INTO tblusers "
+ "(first_name, middle_initial, last_name, course_id, school_id, username, password, privilege)"
+ " VALUES "
+ "('" + txtFn + "','" + txtMi + "','" + txtLn + "'," + cmbCourseKey + "," + cmbSchoolKey + ","
+ "'" + txtUser + "','" + txtPass + "','student')";
            stmt.executeUpdate(query);