public void onDateSet(DatePicker view, int year, int month, int day) {
    Calendar calendar = Calendar.getInstance();
    calendar.set(year, month, day);

    SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM");
    String output = formatter.format(calendar.getTime()); //eg: "Tue May"
}