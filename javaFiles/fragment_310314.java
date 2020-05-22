final long MILLIS_PER_SECOND = 1000;
final long SECONDS_PER_HOUR = 3600;
final long SECONDS_PER_MINUTE = 60;

long deltaSeconds = time_left / MILLIS_PER_SECOND;
long deltaHours = deltaSeconds / SECONDS_PER_HOUR;
long leftoverSeconds = deltaSeconds % SECONDS_PER_HOUR;
long deltaMinutes = leftoverSeconds / SECONDS_PER_MINUTE;

Toast.makeText(getBaseContext(), 
      String.format(Locale.US, "Alarm set for %d hours and %d minutes", deltaHours, deltaMinutes),
      Toast.LENGTH_SHORT).show();