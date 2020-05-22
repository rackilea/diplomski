...
if (flag == 1 && Integer.parseInt(callType) == CallLog.Calls.MISSED_TYPE) {
  dir = "MISSED";
  sb.append("\nName: " + namee + "\nPhone Number:  " + phNumber + " \nCall Type:  " + dir + " \nCall Date:   " + callDayTime
    + " \nCall duration in sec :   " + callDuration);
  param = 1;
}
...