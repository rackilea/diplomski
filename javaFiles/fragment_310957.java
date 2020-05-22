import java.util.regex.*;

...

String data = "letters.1223434.more_letters";
String pattern="(.+?)\\.(.+?)\\.(.+)";
Matcher m = Pattern.compile(pattern).matcher(data);
if (m.find()) //or while if needed
    for (int i = 1; i <= m.groupCount(); i++) 
    //group 0 == whole String, so I ignore it and start from i=1
        System.out.println(i+") [" + m.group(i) + "] start="+m.start(i));
// OUT:
//1) [letters] start=0
//2) [1223434] start=8
//3) [more_letters] start=16