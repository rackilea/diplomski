public ArrayList<FacebookUser> getRecommendations(FacebookUser user, ArrayList<FacebookUser> alreadyVisited)
{
  ArrayList<FacebookUser> friends = new ArrayList<FacebookUser>();
  alreadyVisited.add(user);
  if (user.getFriends().size() > 0) {
    friends.addAll(user.getFriends());
    for(FacebookUser fbu : user.getFriends())
      if(!alreadyVisited.contains(fbu))
        getRecommendations(fbu, alreadyVisited).stream().filter(x -> !friends.contains(x)).forEach(x -> friends.add(x));
  }
  return friends;
}