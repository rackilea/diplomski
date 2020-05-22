public boolean insertLocation2(String place, String location, String latitudey, String longitudey)
{
    SQLiteDatabase database = this.getWritableDatabase();
    ContentValues values = new ContentValues();
    values.put("latitudey",latitudey);
    values.put("longitudey", longitudey);
    database.update("locations", values, "place=? and location=?", new String[] {place, location});
    database.close();
    return true;
}