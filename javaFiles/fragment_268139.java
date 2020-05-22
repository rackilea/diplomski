private String getDateComponentFromHTML(String componentName, String html) {
    String dateComponent = null;
    Pattern p = Pattern.compile("<select name=\"" + componentName + "\".*?<.*?selected.*?\\(d{2})");
    Matcher m = p.matcher(html);
    if (m.find()) {
        dateComponent = m.toMatchResult().group(1);
    }
    return dateComponent;
}