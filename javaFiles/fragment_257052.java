String in = "i have a male cat. the color of male cat is Black";
int i = 0;
Pattern p = Pattern.compile("male cat");
Matcher m = p.matcher( in );
while (m.find()) {
    i++;
}
System.out.println(i); // Prints 2