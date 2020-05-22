try {
        // Create sql statements

        String updateSql = "update ResultUpload set ca = ?, exams = ?, total = ?, AAA=?, BPLUS=?, BBB=?, CPLUS=?, CCC=?, DDD=?, EEE=?, FFF=?, gpp=?, ugp=?, remarks=?, unit=?, level=?, courseName=?, semester=? where idnumber=? and courseCode=?";
        String insertSql = "Insert into ResultUpload (idnumber,ca,exams,total,AAA,BPLUS,BBB,CPLUS,CCC,DDD,EEE,FFF,gpp,ugp,remarks,unit,level,courseCode,courseName,semester) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String sql = "select idnumber, courseCode from ResultUpload where idnumber = ? and courseCode = ?"; 

        BufferedReader br = new BufferedReader(new FileReader("fileName"));
        Connection conn = null;

        // Create PreparedStatement objects for both queries; and this
        // should be done outside of the loop
        PreparedStatement insertStatement = conn.prepareStatement(insertSql);
        PreparedStatement updateStatement = conn.prepareStatement(upadteSql);
        PreparedStatement pst = conn.prepareStatement(sql);

        String line;
        while ((line = br.readLine()) != null) {
            String[] value = line.split(","); // check this line that it is not null
            pst.setString(1, value[0]);
            pst.setString(2, value[1]); 
            ResultSet rs = pst.executeQuery();
            if (rs.next()) { // if there is an entry in the DB make update
                updateRecord(updateStatement, value);
            } else {
                insertRecord(insertStatement, value);
            }
            rs.close();
        }
        br.close();  // close these resources in the finally block
        insertStatement.close();
        updateStatement.close();
        conn.close();
    } catch (SQLException ex) {
        ex.printStackTrace();
    } catch (IOException ex) {
        ex.printStackTrace();
    }

private static void updateRecord(PreparedStatement preparedStatement,
        String[] value) throws SQLException {
    preparedStatement.setString(19, value[0]); // in where clause: value of idnumber
    preparedStatement.setString(20, value[1]); // in where clause: value of coursecode

    // 
    preparedStatement.setString(1, value[ca]);  // array index for 'ca'
    preparedStatement.setString(2, value[exams]); // array index for 'exams'
    // set values for rest of the fields ....

    preparedStatemtn.executeUpdate();
}

private static void insertRecord(PreparedStatement preparedStatement,
        String[] value) throws SQLException {
    preparedStatement.setString(1, value[0]); // index of array for 'idnumber'
    preparedStatement.setString(2, value[]); // index of array for 'ca'
    // set values for rest of the fields ....

    preparedStatement.executeUpdate();
}