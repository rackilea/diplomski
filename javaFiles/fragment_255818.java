public static void main(String[] args) {
    final Calendar calendar = Calendar.getInstance();
    calendar.set(2015, Calendar.AUGUST, 21, 9, 27);
    final Date date = calendar.getTime();
    final String formattedDate = new SimpleDateFormat("yyyy/MM/dd").format(date);
    System.out.println("formattedDate = " + formattedDate);
}