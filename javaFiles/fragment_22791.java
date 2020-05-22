String query = "select ST_GeoJSON(geom) AS geojson, * from a1"
ResultSet resultSet = s.executeQuery(query);
while (resultSet.next()) {
    String geoJSON = resultSet.getString("geojson");
    /* etc */
}