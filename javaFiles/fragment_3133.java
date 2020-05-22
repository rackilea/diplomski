import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HashTagColorizer {

    public static void main(String[] args) {
        String AQUA = "<AQUA>", RESET = "<RESET>";
        String message = "Aaa #hashtag-goes-here bbb #another-hashtag ccc";
        Pattern pattern = Pattern.compile("#([A-Za-z0-9-]+)");
        Matcher matcher = pattern.matcher(message);
        StringBuilder sb = new StringBuilder(message.length());
        int position = 0;
        while (matcher.find(position)) {
            sb.append(message.substring(position, matcher.start()));
            sb.append(AQUA);
            System.out.println("event for " + matcher.group(1));
            sb.append(matcher.group().substring(1));
            sb.append(RESET);
            position = matcher.end();
        }
        sb.append(message.substring(position));
        System.out.println(sb);
        // Aaa <AQUA>hashtag-goes-here<RESET> bbb <AQUA>another-hashtag<RESET> ccc
    }

}