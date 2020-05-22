while (rs.next()){
    return new TrackTime (rs.getInt("id"),
            rs.getDate("date"),
            rs.getTime("startTime").toLocalTime(),
            rs.getTime("endTime").toLocalTime(),
            rs.getString("licenseType"),
            rs.getInt("trackNumber"));
}