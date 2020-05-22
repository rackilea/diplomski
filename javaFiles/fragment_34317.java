String query = "SELECT reception_date,longitude,latitude"
             + " FROM adsb_message"
             + " WHERE mode_s_icao_id = ?"
             + " AND reception_date > ?"
             + " AND reception_date < ?";
PreparedStatement ps = PostgreSQLConnection.getConnection().prepareStatement(query);
ps.setString(1, icao);
ps.setString(2, date_feb);
ps.setString(3, date_fin);
ResultSet result = ps.executeQuery();

while (result.next()) {
    float lat, lon;
    String date;
    lat = result.getFloat("latitude");
    lon = result.getFloat("longitude");
    date = result.getString("reception_date");

    Position pos = new Position(lat,lon,date);
    av.ajoutPos(pos);
}