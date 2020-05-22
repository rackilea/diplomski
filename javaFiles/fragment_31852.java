DBConnection dbc = new DBConnection(this, "MapsDB", null, 1); 
    SQLiteDatabase db = dbc.getWritableDatabase();

    Cursor c = db.rawQuery("SELECT Latitude,Longitude from Records", null);
    if(c.moveToFirst()){ 
        do {
            allLatLng.add(new LatLng(Double.parseDouble(c.getString(0)), Double.parseDouble(c.getString(1))));
        }while (c.moveToNext());
    }
    db.close();
}