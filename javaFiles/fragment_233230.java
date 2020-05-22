class Foobar {
    public static void main(String[] args) {
        sun.util.calendar.ZoneInfo zi = sun.util.calendar.ZoneInfoFile.getZoneInfo("GMT");
        zi.setID("GMT+00:00:00");
    }
}