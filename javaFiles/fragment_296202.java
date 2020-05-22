java.util.Scanner sc = new java.util.Scanner(System.in);
    int rollNo = sc.nextInt();
    PreparedStatement ps = null;
    ResultSet rs = null;
    try {
        ps = conn.prepareStatement("select * from Student where rollno=?");
        ps.setInt(1, rollNo);
        rs = ps.executeQuery();
        while (rs.next()) {
            Integer rollno = rs.getInt("rollno");
            String name = rs.getString("name");
            //other columns
        }
    } catch (Exception e) {
        e.printStackTrace();
    }finally{
        try {
            rs.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            ps.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }