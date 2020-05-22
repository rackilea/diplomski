String s = "Prooo\nJavaaa";
Pattern pattern = Pattern.compile("\\b(?=Ja\\w*a\\b)\\w*?((\\w)\\2+)\\w*\\b");
Matcher matcher = pattern.matcher(s);
while (matcher.find()){
    System.out.println(matcher.group(1)); 
}