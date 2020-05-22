String s = "<$FB $TWTR are getting plummetted>";
Pattern pattern = Pattern.compile("(?:<|(?!^)\\G)[^>]*?\\$([A-Z]+)");
Matcher matcher = pattern.matcher(s);
while (matcher.find()){
    System.out.println(matcher.group(1)); 
}