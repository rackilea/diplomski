String text = "{return a.reverse()}};function jo(a){a=a.split(\"\");a=io.aS(a,53);a=io.Y7(a,19);a=io.aS(a,9);a=io.km(a,2);a=io.Y7(a,29);a=io.km(a,1);return a.join(\"\")};function ko(){};var lo";

String funcname = Pattern.quote("jo");// lets excape potential regex
                                      // special characters

Pattern p2 = Pattern.compile("(?:function " + funcname + "|[{;]"
        + funcname + "\\s*=\\s*function)\\((.*?[a-z,]+)\\)\\{(.*?[^}]+)\\}");

Matcher m = p2.matcher(text);
while (m.find())
    System.out.println(m.group(2));