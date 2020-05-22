@JsonIgnore
public String getDateCreatedFormatted() {
    SimpleDateFormat format = new SimpleDateFormat("EEE MMM d yyyy h:mm:ss a z", Locale.US);
    format.setTimeZone(TimeZone.getTimeZone("America/New_York"));
    return format.format(getDateCreated());
}