private String getFormate(String date) {
    String formattedDate = null;

    try {
        String[] dates = date.split("\\(|\\)");
        Long timeInMillis = Long.parseLong(dates[1]);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeInMillis);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm a");
        formattedDate = simpleDateFormat.format(calendar.getTime());
    } catch (Exception ex) {
        ex.printStackTrace();
    }

    return formattedDate;
}