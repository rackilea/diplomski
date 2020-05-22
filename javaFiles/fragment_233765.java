final FriendBuilder john = new FriendBuilder().setName("john");
final FriendBuilder mary = new FriendBuilder().setName("mary");
final FriendBuilder susan = new FriendBuilder().setName("susan");
john
  .likes(mary)
  .likes(susan);
mary
   .likes(susan)
   .likes(john);
susan
   .likes(john);

// okay lets build the immutable Friends
Map<Friend> friends = FriendsBuilder.createCircleOfFriends(john, mary, susan);
Friend immutableJohn = friends.get("john");