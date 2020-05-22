import java.util.Calendar;

public class CustomerVisit {
    private Calendar enterTime;
    private Calendar leaveTime;


    public Calendar getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(Calendar enterTime) {
        this.enterTime = enterTime;
    }

    public Calendar getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(Calendar leaveTime) {
        this.leaveTime = leaveTime;
    }

    public boolean isVisit(Calendar givenTime) {
        if (givenTime.after(enterTime) && givenTime.before(leaveTime)) {
            return true;
        } else {
            return false;
        }
    }

    public void setVisit(String visitString) {
        // File format is hh:mm-hh:mm
        String[] times = visitString.split("-");
        String[] enterTimeString = times[0].split(":");
        String[] leaveTimeString = times[1].split(":");

        enterTime = setCalendar(enterTimeString);
        leaveTime = setCalendar(leaveTimeString);
    }

    private Calendar setCalendar(String[] timeString) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 
                Integer.valueOf(timeString[0]));
        calendar.set(Calendar.MINUTE, 
                Integer.valueOf(timeString[1]));
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar;
    }
}