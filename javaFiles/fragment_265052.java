public static void calculateRemainTime(String scheduled_date){

    // date format
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    // two dates
    java.util.Date scheduledDate;
    Calendar current = Calendar.getInstance();
    java.util.Date currentDate;
    String current_date = format.format(current.getTime());
        try {
            scheduledDate = format.parse(scheduled_date);
            currentDate = format.parse(current_date);
            long diffInMillies = scheduledDate.getTime() - currentDate.getTime();
            long diffence_in_minute = TimeUnit.MINUTES.convert(diffInMillies,TimeUnit.MILLISECONDS);
            System.out.println(diffence_in_minute);
        } catch (ParseException e) {
            e.printStackTrace();
        }
}