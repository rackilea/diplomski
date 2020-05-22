Connection db = DriverManager.getConnection( /* these parameters are up to you */ );

    Statement st = db.createStatement();
    ResultSet rs = st.executeQuery("select value, length(value) from x");
    while(rs.next()){
        String value = rs.getString(1);
        int length = rs.getInt(2);

        System.out.println("length="+length+", value='"+value+"'");
    }