String st = "st1 15";
String sta = "15";
ArrayList<String> arrlist = new ArrayList<String>(5);
arrlist.add("string string string 15");

if (st.contains(sta)) {
    boolean shouldAdd = true;
    for ( String val : arrlist ) {
        if (val.contains(sta)) {
            shouldAdd = false;
            break;
        }
    }
    if ( shouldAdd ) {
      arrlist.add(st);                      
    }
}