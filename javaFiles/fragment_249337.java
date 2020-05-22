public static void main(String...args) {
    // get a calendar instance instantiated with today's date 
    // this would be your start or end date in your program
    GregorianCalendar gc = new GregorianCalendar();     
    System.out.println(gc.getActualMaximum(Calendar.DAY_OF_MONTH));     
}