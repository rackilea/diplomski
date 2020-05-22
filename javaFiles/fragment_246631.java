public void loadReservations() {

    ListView lv = (ListView) this.findViewById(R.id.waitingList);

    String url = "jdbc:mysql://"+dbURL+":"+dbPort+"/"+dbDatabase+"";
    String user = dbUser;
    String pass = dbPass;

    try {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, user, pass);

        Statement st = con.createStatement();
        final ResultSet rs = st.executeQuery("SELECT cust_name, reserve_Date, Seat_prefer, reserve_people, Notes, no_sms_service FROM seat_reserve WHERE reserve_Close=0 && DATE(reserve_Date) = DATE(NOW()) ORDER BY reserve_Date ASC");
        ResultSetMetaData rsmd = rs.getMetaData();

        // clear out the waitingList (instead of making a brand new one!)
        waitingList.clear();

        while (rs.next()) {
            ListItemData data = new ListItemData(rs);

            waitingList.add(data);
        }

        // this must be called to notify the list to recalculate it's view
        arrayAdapter.notifyDataSetChanged();

    } catch(Exception e) {
        e.printStackTrace();
    }
}