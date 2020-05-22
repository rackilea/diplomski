Pattern pattern = Pattern.compile("[0-9]{2}/[0-9]{2}/([0-9]{4}),[^,]+,([0-9.]+),");
String text = "01/02/2017,546.12,24.2,";
Matcher matcher = pattern.matcher(text);
if (matcher.find()) {
    String year = matcher.group(1);
    String lastDecimal = matcher.group(2);
    System.out.println("Year "+year+"; decimal "+lastDecimal);
}