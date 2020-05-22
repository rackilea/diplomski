public class Tuple implement Comparable <Tuple> {
    public boolean isComment;
    public int location;
    public String text;

    public Tuple(boolean isAComment, int aLocation, String aText) {
        isComment = isAComment;
        location = aLocation;
        text = aText;
    }

    public int compareTo (Tuple that) {
        if (location == that.location)
            return Boolean.compare (isComment, that.isComment);
        else
            return Integer.compare (location, that.location);
    }