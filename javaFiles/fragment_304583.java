@Override
    public List<Cita> getCitas(int sesID) {
      List<Cita> citas = new ArrayList<Cita>();
      String consulta = "select iii.estatinforme,s.NUMERO, [...]";
      try (PreparedStatement pstmt = con.prepareStatement()) {
          pstmt.setInt(1, sesID);
          try(ResultSet rs =  pstmt.executeQuery()) {
              while (rs.next()) {
                  //handling my reads...
              }
          }
      } //Closing happend automatically! Even in case of an error!
      catch (SQLException ex) {
          Logger.getLogger(JDBCMySQL.class.getName()).log(Level.SEVERE, null, ex);
      }     
      return citas;
    }