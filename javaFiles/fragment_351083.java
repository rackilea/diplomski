long lCursor = -1;
IDs friendsIDs = twitter.getFriendsIDs(userID, lCursor);
System.out.println(twitter.showUser(userID).getName());
System.out.println("==========================");
do
{
  for (long i : friendsIDs.getIDs())
   {
       System.out.println("follower ID #" + i);
       System.out.println(twitter.showUser(i).getName());
   }
}while(friendsIDs.hasNext());