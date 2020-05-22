String rx = "https?:/(?:/[^/]+)+\\.(?:jpg|gif|png)";
String url = "http://www.medivision360.com/pharma/pages/articleImg/thumbnail/thumb3756d839adc5da3.jpg";
Pattern pat = Pattern.compile(rx);
Matcher matcher = pat.matcher(url);
if (matcher.matches()) {
    System.out.println(matcher.group());
}