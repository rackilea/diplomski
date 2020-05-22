Calendar today = Calendar.getInstance();
int dayOfWeek = today.get(Calendar.DAY_OF_WEEK);
int daysUntilNextFriday = Calendar.FRIDAY - dayOfWeek;
if(daysUntilNextFriday < 0){
    daysUntilNextFriday = daysUntilNextFriday + 7;
}
Calendar nextFriday = (Calendar)today.clone();
nextFriday.add(Calendar.DAY_OF_WEEK, daysUntilNextFriday);
if(nextFriday.get(Calendar.WEEK_OF_YEAR) % 2 == 0){
    nextFriday.add(Calendar.DAY_OF_WEEK, 7);
}
System.out.println(new SimpleDateFormat("dd/MM/yyyy").format(nextFriday.getTime()));