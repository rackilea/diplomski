private static final String FB_START = "<$@FBID@$>";
private static final String FB_END = "<$@ENDFBID@$>";

public static List<User> parseUserList(String userData)
{
    List<User> ret = new ArrayList<User>();

    int index = 0;
    while (index < userData.length())
    {
        int startFbTag = userData.indexOf(FB_START, index);
        if (index == -1)
        {
            // No tags left. You should check whether you've actually got
            // some data left, and potentially throw an exception. It's not
            // clear what your data format does here.
            return ret;
        }
        String name = userData.substring(index, startFbTag - index);
        startFbTag += FB_START.length(); // Start of the actual data
        int endFbTag = userData.indexOf(FB_END, startFbTag);
        if (endFbTag == -1)
        {
            throw new IllegalArgumentException("Unterminated start tag");
        }

        String fbTagValue = userData.substring(startFbTag, endFbTag - startFbTag);
        long fbId = Long.parseLong(fbTagValue);
        ret.add(new User(name, fbId));
        index = endFbTag + FB_END.length();
    }
    return ret;
}