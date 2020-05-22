String s = "1:[1,3,2],2:[1],3:[4,3],4:[4,3],5:[123,53,1231],123:[54,98,434]";
// commented one handles white spaces correctly
//Pattern p = Pattern.compile("[\\d]*\\s*:\\s*\\[((\\d*)(\\s*|\\s*,\\s*))*\\]");
Pattern p = Pattern.compile("[\\d]*:\\[((\\d*)(|,))*\\]");
Matcher matcher = p.matcher(s);

while (matcher.find())
  System.out.println(matcher.group());