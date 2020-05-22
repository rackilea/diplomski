private class Connect extends AsyncTask<String, Void, String> {
    @Override
    protected String doInBackground(String... urls) {
      String response = "";

      try {
          Class.forName("com.mysql.jdbc.Driver");
          Connection con = DriverManager.getConnection(url, user, pass);
          // System.out.println("Database connection success"); 

          String result = "Database connection success\n";
          Statement st = con.createStatement();
          ResultSet rs = st.executeQuery("select * from users");
          ResultSetMetaData rsmd = rs.getMetaData();

          while(rs.next()) {
            result += rsmd.getColumnName(1) + ": " + rs.getInt(1) + "\n";
            result += rsmd.getColumnName(2) + ": " + rs.getString(2) + "\n";
            result += rsmd.getColumnName(3) + ": " + rs.getString(3) + "\n";
          }
          tv.setText(result);
      }
      catch(Exception e) {
          e.printStackTrace();
          tv.setText(e.toString());
      }
    return response;   


    }