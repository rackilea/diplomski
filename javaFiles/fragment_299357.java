private boolean isSet;

public boolean isAlarmSet()
{
    return isSet;
}

public void setAlarm (int hours, int minutes, int seconds)
{
    alarmHour = hours;
    alarmMinute = minutes;
    alarmSecond = seconds;
    isSet = true;
}