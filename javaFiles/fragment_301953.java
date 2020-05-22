// Begin User Input
String userDefinedTZ = "Pacific/Honolulu"; // +11

int userStartYear = 2013;
int userStartMonth = Calendar.JANUARY;
int UserStartDayOfMonth = 27;
int userStartHour = 15;
int userStartMinute = 0;
int userStartSecond = 0;

int userEndYear = 2013;
int userEndMonth = Calendar.JANUARY;
int UserEndDayOfMonth = 31;
int userEndHour = 21;
int userEndMinute = 0;
int userEndSecond = 0;
// End User Input


Calendar userStartDefinedTime = Calendar.getInstance();
// set start schedule by user input
userStartDefinedTime.set(userStartYear, userStartMonth, UserStartDayOfMonth, userStartHour, userStartMinute, userStartSecond);

Calendar userEndDefinedTime = Calendar.getInstance();
// set end schedule by user input
userEndDefinedTime.set(userEndYear, userEndMonth, UserEndDayOfMonth, userEndHour, userEndMinute, userEndSecond);


CronTrigger trigger = newTrigger()
  .withIdentity("name", "group")
  .withSchedule(
    // define timezone for the CronScheduleBuilder
    cronSchedule("0 0/5 14-22 * * ?").inTimeZone(TimeZone.getTimeZone("Pacific/Honolulu"))
  )
  // adapt user start date to server timezone
  .startAt( convertDateToServerTimeZone(userStartDefinedTime.getTime(), userDefinedTZ) )
  // adapt user end date to server timezone
  .endAt( convertDateToServerTimeZone(userEndDefinedTime.getTime(), userDefinedTZ) )
  .build();