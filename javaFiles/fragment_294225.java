Calendar now = Calendar.getInstance();
Calendar start = Calendar.getInstance();
start.setTime (d);

long milliseconds1 = start.getTimeInMillis();
  long milliseconds2 = now.getTimeInMillis();
  long diff = milliseconds2 - milliseconds1;
  long diffSeconds = diff / 1000;
  long diffMinutes = diff / (60 * 1000);
  long diffHours = diff / (60 * 60 * 1000);
  long diffDays = diff / (24 * 60 * 60 * 1000);
  System.out.println("\nThe Date Different Example");
  System.out.println("Time in milliseconds: " + diff
 + " milliseconds.");
  System.out.println("Time in seconds: " + diffSeconds
 + " seconds.");
  System.out.println("Time in minutes: " + diffMinutes 
+ " minutes.");
  System.out.println("Time in hours: " + diffHours 
+ " hours.");
  System.out.println("Time in days: " + diffDays 
+ " days.");
  }