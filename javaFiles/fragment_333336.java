@OneToMany(mappedBy="myFriends")
private List<MyFriends> myFriends;

@OneToMany(mappedBy="me")
private List<MyFriends> iAmFriendOf;

...

Set<MyFriends> getFriends() {
    Set<MyFriends> friends = new HashSet<MyFriends>();
    friends.addAll(myFriends);
    friends.addAll(iAmFriendOf);
    return friends;
}