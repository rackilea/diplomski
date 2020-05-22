/*JDBC Connection URL*/
private static final String url = "jdbc:mysql://192.168.10.0:8000/etm";
/*JDBC Connection USER NAME*/
private static final String user = "admin";
/*JDBC Connection PASSWORD*/
private static final String pass = "admin";
/*ArrayList to store bus stop names*/
private static ArrayList<String> busStops;




private static class RetrieveSQL extends AsyncTask<Void, Void, ArrayList> {

        @Override
        protected ArrayList doInBackground(Void... voids) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (Exception e) {
                System.err.println("Cannot create connection");
            }
            Connection connection;
            busStops.clear();
            try {
                connection = DriverManager.getConnection(url, user, pass);
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery("select * from stops");
                while (rs.next()) {
                    busStops.add(rs.getString("c_stop_name"));
                }
            } catch (Exception e) {
                System.err.println("Error");
            }
            return busStops;
        }

        @Override
        protected void onPostExecute(ArrayList busList) {
            super.onPostExecute(busList);
            mView.displayBusStopFromMySqlServer(busList);
        }
    }