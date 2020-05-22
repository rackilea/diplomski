Calendar c = Calendar.getInstance();
int hours = c.get(Calendar.HOUR_OF_DAY);
int minutes = c.get(Calendar.MINUTE);
int seconds = c.get(Calendar.SECOND);

if(hours*3600 + minutes*60 + seconds < 1800){
    // Day changed since last task
}