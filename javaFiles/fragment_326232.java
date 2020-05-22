synchronize(map) {
    map.removeAllMapMarkers();
    MapMarkerUnit x;
    try {
        while (rs.next()) {
           x = new MapMarkerUnit(rs.getDouble("currentlat"),rs.getDouble("currentlon"));
           if (rs.getInt("mobile") == 1) x.setMovement(true);
           else x.setMovement(false);
           x.setIconName(rs.getString("uniticon"));
           x.setPriority(1);
           map.addMapMarker(x);
        }
    }
    catch (SQLException e) {
        System.out.print(e.toString());
    }
}