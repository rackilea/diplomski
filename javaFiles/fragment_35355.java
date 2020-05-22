private String getTime() {
    // get the CURRENT date:
    Date currentDate = new Date();

    // format it and return it:
    return new SimpleDateFormat("MMMM dd, yyyy hh:mm a").format(currentDate);
}