final String mins = parent.getItemAtPosition(pos).toString();
final Pattern minutes = Pattern.compile("([0-9]+) minutes"); 
final Matcher m = minutes.matcher(mins);
String stringMinutes = "0";
if (mins.matches())
{
   stringMinutes = m.group(1);
}  
setAlarm(Integer.parseInt(stringMinutes), stringMinutes);