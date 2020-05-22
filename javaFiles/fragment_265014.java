br = new BufferedReader(new FileReader(file));
    String queryCheck, insert;
    PreparedStatement st;
    ResultSet rs;
    boolean recordFound;
    while ((line = br.readLine()) != null) {
        queryCheck = "SELECT * from DB WHERE Name = ?";
        String[] data1 = line.split(cvsSplitBy);
        System.out.println("Name= " + data1[0] + " , ID= " + data1[1] + " , Age= " + data1[2]);
        st = conn.prepareStatement(queryCheck);
        st.setString(1, data1[0]);
        rs = st.getResultSet();
        recordFound = rs.next();

        if (recordFound) {
            System.out.println(data1[0]+" already exist in the database!");
        }
        else{
            String[] data = line.split(cvsSplitBy);
            insert = "INSERT INTO DB (Name, ID, Age) values (?, ?, ?)";
            pstmt = conn.prepareStatement(insert);
            pstmt.setString(1, data[0]);
            pstmt.setString(2, data[1]);
            pstmt.setString(3, data[2]);
            pstmt.executeUpdate();
        }

    }