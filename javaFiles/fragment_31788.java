String globalID = "60DC6285-1E71-4C30-AE36-043B3F7A4CA6";
String regExpr = "^([A-Z0-9]{3})[A-Z0-9]*|-([A-Z0-9]{3})[A-Z0-9]*$|-([A-Z0-9]{2})[A-Z0-9]*";

Pattern pattern = Pattern.compile(regExpr);
Matcher matcher = pattern.matcher(globalID);
String newGlobalID = "";
while (matcher.find()) {
    for (int i = 1; i <= matcher.groupCount(); i++) {
        newGlobalID += matcher.group(i) != null ? matcher.group(i) : "";
    }
}
System.out.println(newGlobalID);