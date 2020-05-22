public static void main(String[] args) {
    Calendar ca1 = Calendar.getInstance();
    ca1.set(2012, Calendar.SEPTEMBER, 20);
    ca1.setMinimalDaysInFirstWeek(1);
    int wk = ca1.get(Calendar.WEEK_OF_MONTH);
    System.out.println("Week of Month :" + wk);
}