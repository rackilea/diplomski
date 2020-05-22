public void setStart(String month, int day, int year, int hour, int minute)
{
    if (this.startTime == null){
       this.startTime = new Time();
    }
    this.startTime.setDate(month, day, year, hour, minute);
}