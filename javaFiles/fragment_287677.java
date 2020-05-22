Optional<byte[]> loadImageFromDatabase(String imageM) throws SQLException {
   String sql = "select img_imagem from imagem where serial_imagem = ?";
   try (Connection conn = getConnection();
           PreparedStatement pst = conn.prepareStatement(sql)) {
       pst.setString(1, imageM);
       try (ResultSet rs = pst.executeQuery()) {
           if (rs.next()) {
               return Optional.of(rs.getBytes(1)); // ofNullable
           } else {
               return Optional.empty();
           }
       }
    }
}