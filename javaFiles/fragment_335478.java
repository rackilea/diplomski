ps = connection.prepareStatement("SELECT TRAYID, COUNT(PlaceNo) AS OCCUPIED " +
                                            "FROM PLACE " +
                                            "GROUP BY TRAYID " +
                                            "HAVING TRAYID = ?");

ps.setInt(1, trayId);
rs = ps.executeQuery();

if (rs.next()) {
    spaceOccupied = rs.getInt("OCCUPIED");
} else {
    throw new CoolingSystemException();
}