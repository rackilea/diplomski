import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.regex.*;


class Ideone
{
    public static void main (String[] args) throws java.lang.Exception
    {
        String testData = "#1|77|1391436891|1|1|00:1e:58:f4:15:f7|Nexus 4, 4.4, MAKOZ30d $1|1391436893 ?[176.08179, -13.839829, -1.0054213] %PKKV7|00:7f:28:3f:17:9d|-67|2437 %DC2VJ|f8:e4:fb:a0:06:f8|-71|2412 %VVWSP|00:7f:28:d5:92:65|-71|2462 %SVT8H|f8:e4:fb:8e:d6:9b|-77|2437 %ThreeBestFriends|20:10:7a:14:6a:f7|-66|2452 %2X4C8|00:7f:28:44:23:da|-75|2437 %STDGD|f8:e4:fb:70:86:f4|-82|2462 %DeathStar|00:7f:28:be:c8:94|-84|2412 %Freeinternet|00:1e:58:f4:15:f7|-59|2437 %QB657|00:26:62:b7:16:4b|-88|2462 %375F2|00:26:b8:3e:0a:14|-70|2412 %E1K38|00:26:62:cf:90:37|-81|2412";
        String regularExpression = "\\w{2}:\\w{2}:\\w{2}:\\w{2}:\\w{2}:\\w{2}\\W{1}-\\d{2}";

        Pattern pattern = Pattern.compile(regularExpression);
        Matcher matcher = pattern.matcher(testData);
        while(matcher.find()) {
            System.out.println(matcher.group(0));
        }

    }
}