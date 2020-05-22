public static void main(String[] args) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    try {
        Date startDate = sdf.parse("2013-02-20");
        Date endDate = sdf.parse("2013-02-22");
        int workdays = getWorkingDaysBetweenTwoDates(startDate, endDate);
        System.out.println(workdays);
    } catch (Exception e) {
        System.out.println("There's an error somewhere. Check the stacktrace to find it");
        e.printStackTrace(System.out);
    }
}