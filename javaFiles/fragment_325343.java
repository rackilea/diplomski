import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Test
        System.out.println(extractAnchorLinks(
                "This <a href=\"www.google.com\">search engine</a> is the most popular. This <a href=\"www.stackoverflow.com\"> website is the largest online community for developers</a>There are millions of websites today"));
    }

    public static List<String> extractAnchorLinks(String string) {
        List<String> anchorLinkList = new ArrayList<String>();
        final String TAG = "a href=\"";
        final int TAG_LENGTH = TAG.length();
        int startIndex = 0, endIndex = 0;
        String nextSubstring = "";
        do {
            startIndex = string.indexOf(TAG);
            if (startIndex != -1) {
                nextSubstring = string.substring(startIndex + TAG_LENGTH);
                endIndex = nextSubstring.indexOf("\">");
                if (endIndex != -1) {
                    anchorLinkList.add(nextSubstring.substring(0, endIndex));
                }
                string = nextSubstring;
            }
        } while (startIndex != -1 && endIndex != -1);
        return anchorLinkList;
    }
}