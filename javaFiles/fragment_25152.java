public final class Apps {

    public Apps(Resources r){
     DIALOGUE = new String[]{
        r.getString(R.string.text1),
        r.getString(R.string.string2),
        r.getString(R.string.string3)};
    }


/**
 * Our data, part 1.
 */
public static final String[] TITLES =
{
        "title1",
        "title2",
        "title3"
};

/**
 * Our data, part 2.
 */
public static String[] DIALOGUE;
}