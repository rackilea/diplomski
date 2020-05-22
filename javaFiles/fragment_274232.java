String pattern = "^(\\d{2}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2})" // date
    + "[ ]+(SEVERE|WARNING|INFO|CONFIG|FINE|FINER|FINEST)" // level
    + "[ ]+([^:]+):(\\d+)" // location name, location line
    + "[ ]+-[ ]+([^:]+): (.*?)" // exception name, exception message
    + "[ ]+Dump: ([a-zA-Z0-9\\./]+)" // dump
    + "$";

Pattern regex = Pattern.compile(pattern);
String input = "09-22-11 12:58:40       SEVERE       ...ractBlobAodCommand:104           -   IllegalStateException: version:1316719189017 not found in recent history                             Dump: /data1/aafghani/dev/devamir/logs/dumps/22i125840.dump";
Matcher m = regex.matcher(input);
assertTrue(m.matches());
assertSame(7, m.groupCount());
for (int i = 1; i <= m.groupCount(); i++) {
  System.out.format("[%d] \"%s\"%n", i, m.group(i));
}