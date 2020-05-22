FileInputStream fis = null;
    PreparedStatement ps = null;
    try {
      conn.setAutoCommit(false);
      File file = new File("myPhoto.png");
      fis = new FileInputStream(file);
      ps = conn.prepareStatement(INSERT_PICTURE);
      ps.setString(1, "001");
      ps.setString(2, "name");
      ps.setBinaryStream(3, fis, (int) file.length());
      ps.executeUpdate();
      conn.commit();
    } finally {
      ps.close();
      fis.close();
    }