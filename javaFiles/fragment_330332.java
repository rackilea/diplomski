String str = "|| and &&";
String rx = "\\|{2}|&&";
Pattern ptrn = Pattern.compile(rx);
Matcher m = ptrn.matcher(str);
if (m.find()) {
   System.out.println("The string has double pipe or ampersands!");
}