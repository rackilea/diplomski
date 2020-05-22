public class TimeClockEntry {

    private Date inTime;
    private Date outTime;
    private int employeeID;

    public TimeClockEntry(String text) throws ParseException {
        String parts[] = text.split(" ");
        employeeID = Integer.parseInt(parts[2]);
        setClockTimeFrom(text);
    }

    public void setClockTimeFrom(String text) throws ParseException {
        String parts[] = text.split(" ");
        if ("in".equalsIgnoreCase(parts[3])) {
            inTime = CLOCK_DATE_TIME_FORMAT.parse(parts[0] + " " + parts[1]);
        } else if ("out".equalsIgnoreCase(parts[3])) {
            outTime = CLOCK_DATE_TIME_FORMAT.parse(parts[0] + " " + parts[1]);
        }
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public Date getInTime() {
        return inTime;
    }

    public Date getOutTime() {
        return outTime;
    }

}