String line = "mappings([map(-1000,[ev(-1000,'C0018017','Objective','Goals',[objective],[inpr],[[[1,1],[1,1],0]],yes,no)])]).";
String regex = 
    "mappings([map(number,[ev(number,<quoted>,quoted,quoted,[csv],[<csv>],[<matchmap>],yesno,yesno)])])."
    .replaceAll("([\\.\\(\\)\\[\\]])", "\\\\$1") // escape metacharacters
    .replace("<", "(").replace(">", ")") // set up capture groups
    .replace("number", "-?\\d+")
    .replace("quoted", "'[^']*'")
    .replace("yesno", "(?:yes|no)")
    .replace("csv", "[^\\]]*")
    .replace("matchmap", ".*?")
;
System.out.println(regex);
// prints "mappings\(\[map\(-?\d+,\[ev\(-?\d+,('[^']*'),'[^']*','[^']*',\[[^\]]*\],\[([^\]]*)\],\[(.*?)\],(?:yes|no),(?:yes|no)\)\]\)\]\)\."

Matcher m = Pattern.compile(regex).matcher(line);
if (m.find()) {
    System.out.println(m.group(1)); // prints "'C0018017'"
    System.out.println(m.group(2)); // prints "inpr"
    System.out.println(m.group(3)); // prints "[[1,1],[1,1],0]"
}