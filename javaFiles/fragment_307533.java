public class Test {
    static Calendar OLE_BASE_DATE = Calendar.getInstance();
    static {
        OLE_BASE_DATE.set(1899, 11, 30); // 1899-12-30
    }

    static double oleDateFormat(Calendar cal) {
        long diff = cal.getTimeInMillis() - OLE_BASE_DATE.getTimeInMillis();
        return diff / 86400000L;
    }

    public static void main(String[] args) {
        // get outlook instance etc...
        OleAutomation appointment = invoke(outlook, "CreateItem", 1).getAutomation();
        appointment.setProperty(property(appointment, "Subject"), new Variant("Test"));
        // compute the appointment start & stop
        double todayAtNoon = oleDateFormat(Calendar.getInstance()) + 0.5;
        double todayAt13_12 = oleDateFormat(Calendar.getInstance()) + 0.55;
        // set the vars
        appointment.setProperty(property(appointment, "Start"), new Variant(String.valueOf(todayAtNoon)));
        appointment.setProperty(property(appointment, "End"), new Variant(String.valueOf(todayAt13_12)));
        appointment.setProperty(property(appointment, "Location"), new Variant("At foo's"));
        // do more stuff
    }
}