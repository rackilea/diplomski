String s = "&1,221.37";
Pattern p = Pattern.compile("[^0-9]*([0-9]*,?([0-9]+(\\.[0-9]*))?)");
Matcher m = p.matcher(s);
m.matches();
String s_num = m.group(1).replace(",", "");
System.out.println(s_num);
Double d_num = Double.valueOf(s_num);
System.out.println(d_num);