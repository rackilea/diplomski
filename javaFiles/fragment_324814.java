Location loc = mLocationClient.getLastLocation();
HashMap hm = new HashMap();
hm.put("LOCATIONS", loc);
Parcel myParcel = Parcel.obtain();    
myParcel.writeMap(hm);
myParcel.setDataPosition(0);

ContentValues values = ContentValues.CREATOR.createFromParcel(myParcel);

getContentResolver().insert(MyDumbUri, values);