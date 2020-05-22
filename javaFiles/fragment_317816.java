public class ExpiringObject {

    private long expiresMS;
    // other properties

    public void setValidity(final int seconds) {
        expiresMS = System.currentTimeMillis() + seconds * 1000;
    }

    public boolean isExpired() {
        return System.currentTimeMillis() >= expireMS;
    }
}