String message = getMessage(data);
String pattern = "\"text\".:.\"([^\"]+)”";
Pattern r = Pattern.compile(pattern);
Matcher m = r.matcher(message);
m.find();
Log.d(LOG_TAG, m.group(1));