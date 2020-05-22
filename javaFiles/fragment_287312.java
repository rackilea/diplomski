String imgStyle = "width: 300px; height: 295px;";
Pattern pattern = Pattern.compile("width:\\s+(\\d+)px;\\s+height:\\s+(\\d+)px;");
Matcher m = pattern.matcher(imgStyle);
if (m.find()) {
    System.out.println("width is " + m.group(1));
    System.out.println("height is " + m.group(2));
}