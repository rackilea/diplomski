public static String getHoursMinutesSeconds(int seconds) {
    int minutes = seconds / 60;
    seconds %= 60;
    int hours = minutes / 60;
    minutes %= 60;

    String strSec = Integer.toString(seconds);
    String strMin = Integer.toString(minutes);
    String strHour = Integer.toString(hours);
    StringBuilder sb = new StringBuilder();
    if (strHour.length() < 2) sb.append(0);
    sb.append(strHour);
    sb.append(':');
    if (strMin.length() < 2) sb.append(0);
    sb.append(strMin);
    sb.append(':');
    if (strSec.length() < 2) sb.append(0);
    sb.append(strSec);

    return sb.toString();
}