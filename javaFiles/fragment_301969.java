String s = "[TEST][64894]HelloWorld[KGMObilians]";
Pattern patt = Pattern.compile("\\[(\\d+)\\]");
Matcher match = patt.matcher(s);
while(match.find()){
    System.out.println(match.group(1));
}