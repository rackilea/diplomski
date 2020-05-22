// this gives you the milliseconds of timezione GMT
long currentTime = System.currentTimeMillis();
// you remove the milliseconds related to GMT
...
// you print the date related to your timezone, which has an offset of +08:00
System.out.println(new Date(startTimeOfToday));