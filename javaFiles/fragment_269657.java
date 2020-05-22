String line = "Here is a #hashtag and here is #another has tag.";
String pattern = "(?<=\\s|^)#\\S+";
Pattern r = Pattern.compile(pattern);
Matcher m = r.matcher(line);
while (m.find()) {
    System.out.println(m.group(0));
}

#hashtag
#another