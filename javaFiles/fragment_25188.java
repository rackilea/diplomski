public Image getImageById(String id) throws SQLException, IOException  {

    try (
        Connection con = ... ;
        PreparedStatement ps = con.prepareStatement(
            "SELECT foto_visi FROM visitantes WHERE cedula_visi = ?");
    ) {

        ps.setString(1, id);
        ResultSet results = ps.executeQuery();
        Image img = null ;
        if (results.next()) {
            Blob foto = results.getBlob("foto_visi");
            InputStream is = foto.getBinaryStream();
            img = new Image(is, false) ; // false = no background loading
            is.close();
        }
        results.close();
        return img ;
    }
}