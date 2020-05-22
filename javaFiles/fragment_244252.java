public class TimedEventsMgr {
    private TreeSet<Date> pointsInTime = new TreeSet<Date>();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd hh:mm a");

    //timeStr: hh:mm AM/PM
    public void add(String timeStr) throws ParseException{
        Date time = sdf.parse("20000101 "+timeStr);
        pointsInTime.add(time);
    }

    public Date closestFutureTime(Date time){
        Calendar c = Calendar.getInstance();
        c.setTime(time);
        c.set(Calendar.YEAR, 2000);
        c.set(Calendar.MONTH, 0); //January
        c.set(Calendar.DATE, 1);
        return pointsInTime.higher(c.getTime());
    }
}