Pattern countRx = Pattern.compile("[</]div[ />]", Pattern.CASE_INSENSITIVE);
Matcher m = countRx.matcher(sHtml);
int count = 0;
while (m.find()) {
    count++;
}
System.out.println(count);