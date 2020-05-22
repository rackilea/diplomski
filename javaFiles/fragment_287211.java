String tweet = "@HIMYM_CBS: Barney Stinson. That Guy's Awesome";
Pattern p = Pattern.compile("@(\\w+)");
Matcher m = p.matcher(tweet);
if (m.find()) {
  System.out.println(m.group(1));
} else {
  System.out.println("not found.");
}