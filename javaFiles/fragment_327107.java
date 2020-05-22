public class Facebook {

    private MutableLong id = new MutableLong();
    public Long getId() { return id.longValue(); }
    public void setId(Long id) { this.id.setValue(id); }

    public MutableLong getIdAsMutableLong() {
        return id;
    }

    private Collection<MyFriends> myFriends = new ArrayList<MyFriends>();
    public Collection<MyFriends> getMyFriends() { return myFriends; }
    public void setMyFriends(Collection<MyFriends> myFriends) { this.myFriends = myFriends; }

    /**
     * add convenience method
     */
    public void addFriend(Facebook myFriendFacebook) {
        myFriends.add(new MyFriends(this, myFriendFacebook));
    }

}