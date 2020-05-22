String regex = "(?:^\\d+,\\d+.*|\\G(?!^))\\R\\h+([A-Z])\\R.*\\/";
String stringtext = "0,10 - 0,20 0,30 - 0,40, 0,50 - 0,60\n"
     + "                     A\n"
     + "                     /\n"
     + "                     B\n"
     + "                     /\n"
     + "                     C\n"
     + "                     /\n"
     + "                     D\n"
     + "                     /;";

Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher(stringtext);

while (matcher.find()) {
    System.out.println(matcher.group(1));
}