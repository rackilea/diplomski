@Override
public Uri insert( final Uri uri, final ContentValues oldvalues ){
SQLiteDatabase db = GAELdatabase.getWritableDatabase();

Uri result = null;
Location loc = (Location)oldvalues.get("LOCATIONS");

ContentValues values = new ContentValues();

values.put("ALTITUDE", loc.getAltitude());//meters above sea level
values.put("LATITUDE", loc.getLatitude());
values.put("LONGITUDE", loc.getLongitude());

long rowID = db.insert( "MyTABLE_NAME", "", values);
db.close();
return result;
}