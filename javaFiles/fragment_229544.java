public class URLResonstruction {


    public static String reconstructURL(String url) {
        int beginTknInx = url.indexOf("IDToken1");

        // If there is no IDToken
        if (beginTknInx < 0)
            return url;

        // If IDToken is only query parameter or IDToken is at end
        int endTknInx = url.substring(beginTknInx).indexOf("&");
        if (endTknInx < 0)
            return url.substring(0, beginTknInx - 1);

        // If IDToken is at beginning or in middle
        String part1 = url.substring(0, beginTknInx);
        String part2 = url.substring(beginTknInx + endTknInx);
        return part1 + part2.substring(1, part2.length());
    }
}