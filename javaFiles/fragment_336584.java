class MyRealmObject extends RealmObject {
    private String alarmName;
    private Boolean alarmActive = true;
    private Date alarmTime;
    private String alarmTonePath = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM).toString();
    private Boolean alarmVibrate = true;
    private byte[] serializedCalendar;

    public Calendar getCalendar() {
        return deserializeCalendar(serializedCalendar);
    }

    public void setCalendar(Calendar calendar) {
        this.serializedCalendar = serializeCalendar(calendar);
    }
}