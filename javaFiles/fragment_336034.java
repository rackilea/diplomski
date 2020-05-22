public static void main(String[] args){
    Calendar cal = Calendar.getInstance();
    cal.set(Calendar.YEAR, 2014);
    cal.set(Calendar.WEEK_OF_YEAR,2);
    System.out.println(cal.get(Calendar.YEAR) + " "+ cal.get(Calendar.WEEK_OF_YEAR));

    cal.add(Calendar.WEEK_OF_YEAR, 200);
    System.out.println(cal.get(Calendar.YEAR) + " "+ cal.get(Calendar.WEEK_OF_YEAR));


}