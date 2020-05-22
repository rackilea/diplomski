String  date = getDate(selectedDate);

private String getDate(String inpuDate) {
    Date date = new SimpleDateFormat("EEE MMM d hh:mm:ss z yyyy").parse(inputDate);
    return new SimpleDateFormat("dd.MM.yyyy hh:mm:ss").format(date);
}