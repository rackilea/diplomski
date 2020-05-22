public Station getSingleStationDetails(int stationID) {
    // I assume that your station's table name is DatabaseHelperStations.TABLE_NAME
    // and that it has a column named DatabaseHelperStations.COLUMN_ID 

    String selectQuery = "SELECT * FROM " + DatabaseHelperStations.TABLE_NAME + " WHERE " + DatabaseHelperStations.COLUMN_ID + " = " + stationID + ";";

    Cursor cursor = database.rawQuery(selectQuery, null);
    Station aStation = null;

    if (cursor.moveToFirst()) {
        aStation = cursorToStation(cursor);
    }

    cursor.close();

    return aStation;
}