public int getIdArtist(String artistName){

    Conexion connection=new Conexion();
    int id=0;

    try{
        String cSql="SELECT ArtistId from artist where Name=?";
        PreparedStatement sqlArtistId=connection.getConnection().prepareStatement(cSql);
        sqlArtistId.setString(1, artistName);
        ResultSet result=sqlArtistId.executeQuery();
        System.out.println(id); //debug
        while(result.next()){
            id=result.getInt("ArtistId");
        }
        return id;
    }catch(SQLException exception){
        exception.printStackTrace();
        return 0;
    }
}