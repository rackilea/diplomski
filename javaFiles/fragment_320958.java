String input = "%5B%7E%5D";
String link = "%5B%7E%5D/assets.jpg"; 
Pattern p = Pattern.compile(Pattern.quote(input));
System.out.println(p.matcher(input).matches());
System.out.println(p.matcher(input).find());
System.out.println(p.matcher(link).matches());
System.out.println(p.matcher(link).find());