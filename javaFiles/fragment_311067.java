char dash = '\u2010'; // 2010 is hyphen, 002D is hyphen-minus
int i = -1;
String a = "(country)" + dash + "(US)" + dash + i;
Pattern p = Pattern.compile("\u2010", Pattern.LITERAL);
String[] m = p.split(a);
for (String s : m) {
    System.out.println(s);
}