String msg = "Peach, a nice family of fruits. Apple are not. Another Peach foo bar is here Apple end.";
Pattern p = Pattern.compile(
      "(?:(?<=\\bPeach\\b|\\G)\\W)(?:(?!\\bApple\\b).)*?\\b((?!Apple\\b)\\w{3,})\\b");

Matcher m = p.matcher(msg);
while (m.find()) {
    System.out.println(m.group(1));
}