public class Profile implements ProfileInterface
{
    // List of all friends.
    private List<Profile> friendProfiles;

    public Profile()
    {
        friendProfiles = new List<Profile>();
    }

    public Profile getRandomFriend()
    {
        if (friendProfiles.size() == 0)
            return null;
        else
            return friendProfiles.get((int)(Math.random() * friendProfiles.size())
    }

    public void addFriend(Profile friend)
    {
        friendProfiles.add(friend);
    }

    public Profile recommend()
    {
        Profile friend = this.getRandomFriend();
        return friend.getRandomFriend();
    }
}