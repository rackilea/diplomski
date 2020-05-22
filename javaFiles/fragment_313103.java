public class Avatar {
    private Long userId;
    private Long currentHomeId;
    private Long clanId;

    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Long getCurrentHomeId() {
        return currentHomeId;
    }
    public void setCurrentHomeId(Long currentHomeId) {
        this.currentHomeId = currentHomeId;
    }
    public Long getClanId() {
        return clanId;
    }
    public void setClanId(Long clanId) {
        this.clanId = clanId;
    }
}