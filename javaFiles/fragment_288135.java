String content = "0011221100";
 int zeros = content.length() - content.replaceAll("0", "").length();
 int ones = content.length() - content.replaceAll("1", "").length();
 int twos = content.length() - content.replaceAll("2", "").length();
 System.out.println("0's:" + zeros);
 System.out.println("1's:" + ones);
 System.out.println("3's:" + twos);