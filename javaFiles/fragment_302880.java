String s = "Hello, :smile::hearth: world!";
Pattern p = Pattern.compile(":[^:]+:|\\S+");
Matcher m = p.matcher(s);
while(m.find()) {
    System.out.println(m.group());
}