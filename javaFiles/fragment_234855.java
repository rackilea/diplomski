String sqlUpdatingWithGeoJsonAsPlaceHolder = 
        "  UPDATE polygons  " +
        "   SET  " +
        "       geom = ST_SetSRID(ST_GeomFromGeoJSON(?), 26918)  " +
        "   WHERE polygonid = ?  ";         

ps = connection.prepareStatement(sqlUpdatingWithGeoJsonAsPlaceHolder);
ps.setString(1, geoJson);
ps.setLong(2, idForPolygonToUpdate);      
ps.executeUpdate();