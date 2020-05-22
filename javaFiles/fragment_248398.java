String s = "[id='id1' or id='id2' or id='id3']";
Pattern regex = Pattern.compile("(?<=id=')[^']+");
Matcher matcher = regex.matcher(s);
while(matcher.find()){
        System.out.println(matcher.group(0));
}