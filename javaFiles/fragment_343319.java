public class MatcherTest {

    public static void main(String[] args) {

        String word = "wata what word down a adf asdfasdf";

        Pattern p = Pattern.compile("\\w*[wW]+\\w*");
        Matcher m = p.matcher(word);

        while (m.find()) {
            System.out.println(m.group());
        }
    }
}