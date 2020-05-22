public static void main(String[] args) {
     Calendar cal = Calendar.getInstance();
     double year =cal.get(Calendar.YEAR);
     double month=cal.get(Calendar.MONTH);
     double weekOfYear = Calendar.WEEK_OF_YEAR;
     double currentYearWeeks = (year-1)*52 + weekOfYear;
     double weekAgo = (year-1)*52 + weekOfYear -1;
     double monthAgo = (year-1)*52 + weekOfYear - 4;
     System.out.println("Difference:" + (currentYearWeeks - weekAgo));
     System.out.println("Difference:" + (currentYearWeeks - weekAgo));
     System.out.println("Difference:" + (currentYearWeeks - monthAgo));
}