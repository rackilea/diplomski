private static class SubscriptionWrapper {
    BasicUser manager;
    BasicUser userToSubscribe;
    String openid;

    public BasicUser getManager() {
        return manager;
    }
    public void setManager(BasicUser manager) {
        this.manager = manager;
    }
    public BasicUser getUserToSubscribe() {
        return userToSubscribe;
    }
    public void setUserToSubscribe(BasicUser userToSubscribe) {
        this.userToSubscribe = userToSubscribe;
    }
    public String getOpenid() {
        return openid;
    }
    public void setOpenid(String openid) {
        this.openid = openid;
    }
}