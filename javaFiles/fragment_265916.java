int minutes = 260;
int hours = minutes / 60;
int minutesInDisplay = minutes % 60;
if (hours > 23)
    hours = hours % 24;
String postfix = (hours < 12) ? "am" : "pm";
NumberFormat formatter = new DecimalFormat("00");
String display = formatter.format(hours) + ":"
        + formatter.format(minutesInDisplay);
System.out.println("24 hour formatted time: " + display + " " + postfix);