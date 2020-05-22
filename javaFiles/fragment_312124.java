String s = "Arithmetic operators are used in mathematical expressions in the same way that they are used in algebra. The following table lists the arithmetic operators: Assume integer variable A holds 10 and variable B holds 20, then:";

Pattern p = Pattern.compile("\\p{Punct}");
       //or Pattern.compile("[.]{3}|\\p{Punct}"); if you want to find "..."
Matcher m = p.matcher(s);
while (m.find()) {
    System.out.println(m.group());
}