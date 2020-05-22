Pattern pat = Pattern.compile("Handicap Accessible ([A-Za-z]*)");
Matcher match = pat.matcher(sum);
String newAccess = null;
while (match.find()) {
    newAccess = match.group(1);
    break;
}