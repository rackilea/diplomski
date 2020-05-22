Uri l_eventUri; 
l_eventUri = Uri.parse("content://com.android.calendar/events");

    Cursor l_managedCursor = null;  
     l_managedCursor = this.managedQuery(l_eventUri, null,null, null, null);


     l_managedCursor.moveToFirst();
    Log.v("TOTAL NUMBER OF EVENTS :",l_managedCursor.getCount()+"");

 for(int i=0;i<l_managedCursor.getCount();i++){
for(int j=0;j<l_managedCursor.getColumnCount();j++){

    Log.d(l_managedCursor.getColumnName(j)+"===>",""+l_managedCursor.getString(j));
}

l_managedCursor.moveToNext();