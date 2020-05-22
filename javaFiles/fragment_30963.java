Pattern p = Pattern.compile("\\p{L}+(?:-\n?\\p{L}+)*");
Matcher m = p.matcher(input);
int count = 0;

while (m.find()) {
   count++;
}