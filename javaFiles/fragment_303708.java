class UserObject implements Comparable<UserObject> {
    private long timestamp;
    ...

    // returns int < 0 (this before o), int > 0 (o before this), or 0 
    public int compareTo(UserObject o) { 
        return Long.compare(this.timestamp, o.timestamp);
    }
}