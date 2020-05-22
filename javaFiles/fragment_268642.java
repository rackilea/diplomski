private static class Data {
    private final String id;
    private final String occurrence;
    private final String timestamp;

    public Data(String id, String occurrence, String timestamp) {
        this.id = id;
        this.occurrence = occurrence;
        this.timestamp = timestamp;
    }

    public String getId() { return id; }
    public String getOccurrence() { return occurrence; }
    public String getTimestamp() { return timestamp; }
    @Override public String toString() { return "[" + id + ", " + occurrence + ", " + timestamp + "]";}
}