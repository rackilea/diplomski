List<String> nameArray = new ArrayList<String>();
List<String> chargeArray = new ArrayList<String>();
String data="";
while(crs.moveToNext()){
    data = crs.getString(crs.getColumnIndex("NAME"));
    nameArray.add(data);
    data = crs.getString(crs.getColumnIndex("CHARGE"));
    chargeArray.add(data);
}