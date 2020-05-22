public Set<FacebookUser> getRecommendations(FacebookUser user, ArrayList<FacebookUser> alreadyVisited)
{
  Set<FacebookUser> friends = new HashSet<FacebookUser>();
  alreadyVisited.add(user);
  if (user.getFriends().size() > 0) {
      friends.addAll(user.getFriends());
      for(FacebookUser fbu : user.getFriends())
        if(!alreadyVisited.contains(fbu))
          friends.addAll(getRecommendations(fbu, alreadyVisited);
  }
  return friends;
}