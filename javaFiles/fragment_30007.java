String source = "00:10:17";
String[] tokens = source.split(":");
int secondsToMs = Integer.parseInt(tokens[2]) * 1000;
int minutesToMs = Integer.parseInt(tokens[1]) * 60000;
int hoursToMs = Integer.parseInt(tokens[0]) * 3600000;
long total = secondsToMs + minutesToMs + hoursToMs;