public void loadLog() throws ClassNotFoundException, SQLException, IOException {

        Class.forName(classForName);
        Connection conn = DriverManager.getConnection(connectionPath);

        String sql = "SELECT audit FROM shell";

        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet resultSet = stmt.executeQuery();

        while (resultSet.next()) {
          File audit = new File(fileOutputPath2);
          FileOutputStream fos = new FileOutputStream(audit);

          byte[] buffer = new byte[1];
          InputStream is = resultSet.getBinaryStream(1);

          while (is.read(buffer) > 0) {
            fos.write(buffer);
          }
          fos.close();
        }
        conn.close();

        System.out.println("SQL Load Done");
    }