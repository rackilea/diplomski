public class DateFunctions {
    // Date related Logic
    private Date startDate;
    private Integer delta;

    @SuppressWarnings("resource")
    public DateFunctions() {
        // ApplicationContext ctx = new
        // ClassPathXmlApplicationContext("date-properties.xml");
        ApplicationContext ctx = new FileSystemXmlApplicationContext(
                "c:\\logAnalyzer\\date-properties.xml");
        // Initializing date related data from spring configuration file
        startDate = (Date) ctx.getBean("startDate");
        delta = (Integer) ctx.getBean("delta");
    }

    public boolean isTimeDiffAcceptable(Date logDate) {

        DateTime dt1, dt2;
        Integer minutesDiff;

        dt1 = new DateTime(logDate);
        dt2 = new DateTime(startDate);

        int daysDiff = Days.daysBetween(dt1, dt2).getDays();

        if (daysDiff == 0) {
            minutesDiff = dt1.getMinuteOfDay() - dt2.getMinuteOfDay();
        } else {
            minutesDiff = 0;
        }

        // System.out.println("minutesDiff : " + minutesDiff);
        // System.out.println("delta : " + delta);

        if (minutesDiff < 0 && (-1 * minutesDiff) < delta) {
            return true;
        } else {
            return false;
        }
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Integer getDelta() {
        return delta;
    }

    public void setDelta(Integer delta) {
        this.delta = delta;
    }

}