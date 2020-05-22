public class MyFriends {

    private MyFriendsId myFriendId;
    public MyFriendsId getmyFriendId(){ return this.myFriendId; }
    public void setmyFriendId(MyFriendsId myFriendId){ this.myFriendId = myFriendId; }

    private Facebook me;
    public Facebook getme() { return this.me; }
    public void setme(Facebook me){ this.me = me; }

    private Facebook myFriend;
    public Facebook getmyFriend() { return this.myFriend; }
    public void setmyFriend(Facebook friend) { this.myFriend = friend; }

    public MyFriends() {}
    public MyFriends(Facebook meFacebook, Facebook myFriendFacebook){
        this.me = meFacebook ;
        this.myFriend = myFriendFacebook;

        this.myFriendId = new MyFriendsId(meFacebook.getIdAsMutableLong(), myFriendFacebook.getIdAsMutableLong());
    }

    public static class MyFriendsId implements Serializable {

        private MutableLong meId = new MutableLong();
        public Long getMeId() { return this.meId.longValue(); }
        public void setMeId(Long id) { this.meId.setValue(id); }

        private MutableLong myFriendId = new MutableLong();
        public Long getMyFriendId(){ return this.myFriendId.longValue(); }
        public void setMyFriendId(Long id) { this.myFriendId.setValue(id); }

        public MyFriendsId() {}
        public MyFriendsId(MutableLong meId, MutableLong myFriendId) {
            this.meId = meId;
            this.myFriendId = myFriendId;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof MyFriendsId))
                return false;

            MyFriendsId other = (MyFriendsId) o;
            return new EqualsBuilder()
                       .append(getMeId(), other.getMeId())
                       .append(getMyFriendId(), getMyFriendId())
                       .isEquals();
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder()
                       .append(getMeId())
                       .append(getMyFriendId())
                       .hashCode();
        }

    }
}