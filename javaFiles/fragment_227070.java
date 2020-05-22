Date d1 = ...;
    Date d2 = ...;
    PreparedStatement ps = con.prepareStatement("SELECT id, consumption, date_time " 
        + "FROM consumption_info WHERE date_time BETWEEN ? AND ? GROUP BY id");
    ps.setDate(1, d1);
    ps.setDate(2, d2);
    ResultSet rs = ps.executeQuery();