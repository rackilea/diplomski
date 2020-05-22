String s = "2+30*4+(5+6)*7";        
Pattern p = Pattern.compile("\\d+|[()+*-]");
Matcher m = p.matcher(s);
while (m.find()) {
      System.out.print("Start index: " + m.start());
      System.out.print(" End index: " + m.end() + " ");
      System.out.println("-----> " + m.group());
}