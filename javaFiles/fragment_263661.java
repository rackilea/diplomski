import java.util.regex.Matcher;
import java.util.regex.Pattern;

final String regex = "^(https?|ftp|file):\\/\\/(www.)?(.*?)\\.(mp3)$";
final String string = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3\n"
     + "http://soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3\n"
     + "http://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3\n"
     + "ftp://soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3\n"
     + "file://localhost/examples/mp3/SoundHelix-Song-1.mp3\n"
     + "file://localhost/examples/mp3/SoundHelix-Song-1.wav\n"
     + "file://localhost/examples/mp3/SoundHelix-Song-1.avi\n"
     + "file://localhost/examples/mp3/SoundHelix-Song-1.m4a";

final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
final Matcher matcher = pattern.matcher(string);

while (matcher.find()) {
    System.out.println("Full match: " + matcher.group(0));
    for (int i = 1; i <= matcher.groupCount(); i++) {
        System.out.println("Group " + i + ": " + matcher.group(i));
    }
}