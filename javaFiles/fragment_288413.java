String data = "https://www.facebook.com/pages/Anti-Christian-sentiment/149675731889496?ref=br_tf";
Pattern p = Pattern.compile("([^/?]+)(\\?|$)");
Matcher m = p.matcher(data);
if (m.find()){
    System.out.println(m.group(1));
}