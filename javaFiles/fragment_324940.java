Matcher m = Pattern.compile("<([^<>]+?)><([^<>]+?)> and <([^<>]+?)>").matcher(string);

if (m.find()) {
    String name = m.group(1);
    String address = m.group(2);
    String phone = m.group(3);
}