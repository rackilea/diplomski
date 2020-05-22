try (Statement s = conn.createStatement()) {
    s.executeUpdate(
            "INSERT INTO tblDates " +
            "(ID, mmddyyyy) " +
            "VALUES " +
            "('literal', #12/25/2014#)"
            );
}

SimpleDateFormat mmddyyyyFormat = new SimpleDateFormat("MM/dd/yyyy");
Timestamp mmddyyyyXmas = 
        new Timestamp(mmddyyyyFormat.parse("12/25/2014").getTime());

SimpleDateFormat ddmmyyyyFormat = new SimpleDateFormat("dd/MM/yyyy");
Timestamp ddmmyyyyXmas = 
        new Timestamp(ddmmyyyyFormat.parse("25/12/2014").getTime());

SimpleDateFormat yyyymmddFormat = new SimpleDateFormat("yyyy/MM/dd");
Timestamp yyyymmddXmas = 
        new Timestamp(yyyymmddFormat.parse("2014/12/25").getTime());

try (PreparedStatement ps = conn.prepareStatement(
        "INSERT INTO tblDates " +
        "(ID, mmddyyyy, ddmmyyyy, yyyymmdd) " +
        "VALUES " +
        "('parameters', ?, ?, ?)"
        )) {
    ps.setTimestamp(1, mmddyyyyXmas);
    ps.setTimestamp(2, ddmmyyyyXmas);
    ps.setTimestamp(3, yyyymmddXmas);
    ps.executeUpdate();
}