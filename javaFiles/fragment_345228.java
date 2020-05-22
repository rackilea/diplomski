protected Time startTime; // Default Time
protected Time endTime; // Default Time
protected String activityDescription;

public void setStart(String month, int day, int year, int hour, int minute)
{
    this.startTime.setDate(month, day, year, hour, minute);
}