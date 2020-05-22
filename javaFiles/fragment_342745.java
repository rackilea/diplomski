public class Rating {

    private String userId;
    private @ServerTimestamp Date timestamp;

    public Rating() {}

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

     public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}