Cursor mCount= db.rawQuery("SELECT snme FROM halt_details WHERE slati BETWEEN '" +LAT+"- 0.1' AND '"+LAT+" + 0.1' AND slng BETWEEN '" +LNG+"- 0.1' AND '"+LNG+" + 0.1'", null);
mCount.moveToFirst();
while (mCount.moveToNext()) {
    double Latitude = mCount.getDouble(2);
    double Longitude = mCount.getDouble(3);
    double dis=Math.sqrt( (Latitude-LAT)*(Latitude-LAT) + (Longitude-LNG)*(Longitude-LNG) );
    if (dis<min_distance){
        destinationname = mCount.getString(4);
        dList.add(destinationname);

    }
}
mCount.close();