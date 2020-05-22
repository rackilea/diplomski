final Pattern pattern = Pattern.compile(",(.+)"); 
final Matcher matcher = pattern.matcher("Hello,World"); 

if (matcher.find()) {
    System.out.println(matcher.group(1));
}