// loop to add every user and lesson selected to watch
String user_id = null;
int lesson_id = 0;
// get the date for the classWatch
Calendar localCalendar = Calendar.getInstance(TimeZone.getDefault());
Date currentTime = localCalendar.getTime();

for (int i = 0; i<attendees.size(); i++){
    for (int j = 0; j<lesson_iDs.size(); j++){
         user_id = attendees.get(i);
         lesson_id = lesson_iDs.get(j);
         // to show in patient activity (sends to SQLite)
         watch = new Watch(currentTime, user_id, lesson_id);
         // Do something with watch...
    }
}