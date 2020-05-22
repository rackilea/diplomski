public class CalendarDate implements Comparable<CalendarDate>{

    // doesn't get called by sort
    public int CompareTo(CalendarDate other){
        if(month != other.month){
             return month - other.month;
        } 
        else {
            return day - other.day;
        }
    }

    // gets called by sort
    public int compareTo(CalendarDate other) {
        return 0;
    }
}