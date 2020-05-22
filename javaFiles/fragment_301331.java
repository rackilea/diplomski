String s ="abc | efg || $something(\"arg 1\", \"arg 2||(a|b)\") || 123";   
String patternStr="(?:^|\\|\\|)(?:(?!\\|\\|)(?!\").|\"(?:[^\"\\\\]|\\\\.)*\")*";
Pattern p = Pattern.compile(patternStr);
Matcher m = p.matcher(s);
while (m.find()){
    System.out.println(m.group(1));
}