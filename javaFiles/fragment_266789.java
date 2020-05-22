//all version of android
 Intent i = new Intent();

 // mimeType will popup the chooser any  for any implementing application (e.g. the built in calendar or applications such as "Business calendar"
 i.setType("vnd.android.cursor.item/event"); 

 // the time the event should start in millis. This example uses now as the start time and ends in 1 hour
 i.putExtra("beginTime", new Date().getTime()); 
 i.putExtra("endTime", new Date().getTime() + DateUtils.HOUR_IN_MILLIS);

 // the action
 i.setAction(Intent.ACTION_EDIT);
 startActivity(i);