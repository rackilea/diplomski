public String formatDate(Date date) {
    if (date != null) {
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd yyyy");
        return sdf.format(date);
    }
    return null;
}