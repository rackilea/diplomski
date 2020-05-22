public List<String> dbConnect(String Host, String Port, String db_userid,
                String db_password) {
            List<String> Db_list = new ArrayList<String>();
            try {
                String ConnectionString = "jdbc:jtds:sqlserver://" + Host + ":"
                        + Port;
                // Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
                Connection conn = DriverManager.getConnection(ConnectionString,
                        db_userid, db_password);
                System.out.println("connected");
                Statement statement = conn.createStatement();
                String queryString = "select name from sys.databases";
                ResultSet rs = statement.executeQuery(queryString);
                while (rs.next()) {
                    Db_list.add(rs.getString(1));
                }
            } catch (Exception e) {
                Db_list.add("Error");
                e.printStackTrace();
            }
            return Db_list;
        }