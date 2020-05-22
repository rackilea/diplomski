public class MyPojo {
    private String ad;
    private long timestamp;

    public MyPojo(String ad, long timestamp) {
        this.ad = ad;
        this.timestamp = timestamp;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}