public class OneTime extends Appointment {

    public boolean occursOn(int month, int day, int year)  {
        if (day >= 15) {
            return true;
        } else {
            return false;
        }
    }
}