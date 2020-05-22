public static void main(String[] args) {
   Date endDate = new Date(); //current date/time
   Date startDate = getFirstDateOfMonth(endDate);
   int workdays = getWorkingDaysBetweenTwoDates(startDate, endDate);
   System.out.println(workdays);
}