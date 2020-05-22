int count = 0;
String text = "sentence";
Pattern pat = Pattern.compile("e(?!$)");
Matcher m = pat.matcher(text);
while (m.find()) {
        count++;
}
System.out.println(count);